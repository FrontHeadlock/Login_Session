package com.example.testsecurity.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter   // data를 넣어줌
@Getter   // data를 뽑게 해줌
public class JoinDTO {

  //회원가입 폼 데이터 get

  private String username;
  private String password;

}
