package com.example.testsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {

    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .authorizeHttpRequests((auth) -> auth                     // 람다식 작성, 특정 경로에 요청 허용 or 거부
                .requestMatchers("/", "/login").permitAll()   // 특정 경로에 특정 작업 진행
                // 모든 사용자에 한해 PermitAll -> 그냥 접근 가능
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/mypage/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()

        );

    http
        .formLogin((auth) -> auth.loginPage("/login")             // 로그인 페이지 경로 설정
            .loginProcessingUrl("/loginProc")                     // html 로그인 폼 -> 로그인 데이터를 loginProc 경로로 전송
            .permitAll()                                          // 경로에 아무나 접근 가능
        );

    http
        .csrf((auth) -> auth.disable());                          // 사이트 위변조 방지 설정
        // 토큰도 보내줘야 로그인 진행되는데 켜두면 토큰 발급을 해야하니까 잠시 꺼둠


    return http.build();
  }

}
