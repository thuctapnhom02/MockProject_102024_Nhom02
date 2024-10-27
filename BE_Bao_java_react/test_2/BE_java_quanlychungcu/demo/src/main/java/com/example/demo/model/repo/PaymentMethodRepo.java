package com.example.demo.model.repo;

import com.example.demo.model.entity.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepo extends JpaRepository<PaymentMethodEntity,String> {
}
