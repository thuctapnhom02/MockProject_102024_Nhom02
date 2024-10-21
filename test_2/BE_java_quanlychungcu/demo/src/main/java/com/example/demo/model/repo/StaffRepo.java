package com.example.demo.model.repo;

import com.example.demo.model.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepo extends JpaRepository<StaffEntity,String> {
    @Query(value = "SELECT * FROM staff_ WHERE phone_ = ?1", nativeQuery = true)
    StaffEntity findByPhone(String phone_);
//    @Query(value = "SELECT * FROM staff_ WHERE password_ = ?1", nativeQuery = true)
//    StaffEntity findByPass(String pass_);
}
