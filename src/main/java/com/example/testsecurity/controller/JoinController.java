package com.example.testsecurity.controller;

import com.example.testsecurity.DTO.JoinDTO;
import com.example.testsecurity.Service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

  //생성자 주입으로 교체 필요
  @Autowired
  private JoinService joinService;

  @GetMapping("/join")
  public String joinP() {

    return "join";
  }

  @PostMapping("/joinProc")
  public String joinProcess(JoinDTO joinDTO) {

    System.out.println(joinDTO.getUsername());

    joinService.joinProcess(joinDTO);


    return "redirect:/login";
  }

}
