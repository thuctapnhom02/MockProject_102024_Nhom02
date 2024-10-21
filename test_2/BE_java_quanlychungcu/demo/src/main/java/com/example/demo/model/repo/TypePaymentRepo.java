package com.example.demo.model.repo;

import com.example.demo.model.entity.TypePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePaymentRepo extends JpaRepository<TypePaymentEntity,String> {
}
