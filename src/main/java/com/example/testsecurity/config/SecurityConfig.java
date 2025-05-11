package com.example.testsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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


    return http.build();
  }

}
