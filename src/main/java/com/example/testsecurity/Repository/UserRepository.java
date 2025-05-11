package com.example.testsecurity.Repository;

import com.example.testsecurity.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    boolean existsByUsername(String username);
    //특정 username 존재 여부 체크

    UserEntity findByUsername(String username);
}
