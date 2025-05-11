package com.example.testsecurity.Service;

import com.example.testsecurity.DTO.JoinDTO;
import com.example.testsecurity.Entity.UserEntity;
import com.example.testsecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

  // 필드주입 -> 생성자 주입 교체 예정
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;


  public void joinProcess(JoinDTO joinDTO){

    // DB에서 동일한 username 회원 중복여부 검증
    boolean isUser = userRepository.existsByUsername(joinDTO.getUsername());
    if(isUser){
      return;
    }

    // 가입 불가 문자 정규식 처리도 필요

    UserEntity data = new UserEntity();

    data.setUsername(joinDTO.getUsername());
    data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
    data.setRole("ROLE_USER");


    userRepository.save(data);
  }

}
