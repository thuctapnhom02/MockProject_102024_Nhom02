package com.example.demo.model.repo;

import com.example.demo.model.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface PaymentRepo extends JpaRepository<PaymentEntity,String> {
    @Query(value = "SELECT * FROM payment_ WHERE user_id_ = ?1",nativeQuery = true)
    List<PaymentEntity> findByIdUser(String idUser_);

}
