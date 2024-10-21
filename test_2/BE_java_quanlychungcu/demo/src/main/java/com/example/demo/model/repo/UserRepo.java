package com.example.demo.model.repo;

import com.example.demo.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<UserEntity,String> {
    @Query(value = "SELECT * FROM user_ WHERE name_ = ?1 or phone_ = ?2 or email_ = ?3",nativeQuery = true)
    List<UserEntity> findByNamePhoneEmail(String name_, String phone_, String email_);
}
