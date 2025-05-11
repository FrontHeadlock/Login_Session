package com.example.testsecurity.Service;

import com.example.testsecurity.DTO.CustomUserDetails;
import com.example.testsecurity.Entity.UserEntity;
import com.example.testsecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserEntity userData = userRepository.findByUsername(username);

    if (userData != null) {

      return new CustomUserDetails(userData);
    }

    return null;
  }
}