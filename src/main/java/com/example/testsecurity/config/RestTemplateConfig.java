package com.example.testsecurity.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

  // RestTemplate -> OAuth2.0 사용시 HTTP요청 JAVA 객체 -> HTTP 메시지로 변환
  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();

    //HttpMessageConverter : HTTP 요청 응답 JAVA 객체 -> HTTP 메시지로 변환
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    //application/x-www-fomr-urlencoded 방식 요청/응답 처리
    messageConverters.add(new FormHttpMessageConverter());
    restTemplate.setMessageConverters(messageConverters);

    return new RestTemplate();
  }
}
