package com.example.demo.model.repo.bao;

import com.example.demo.model.entity.bao.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepo extends JpaRepository<PaymentMethodEntity,String> {
}
