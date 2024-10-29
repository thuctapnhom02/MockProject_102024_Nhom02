package com.example.demo.model.repo.bao;

import com.example.demo.model.entity.bao.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@EnableJpaRepositories
public interface PaymentRepo extends JpaRepository<PaymentEntity,String> {


    @Modifying
    @Query(value = "update " +
            "payment_ " +
            "set id_payment_method_ = ?1, id_service_ = ?2, payment_dateline_ = ?3, status_ = ?4, total_ = ?5 " +
            "where id_ = ?6", nativeQuery = true)
    void updatePayment(
            String id_payment_method_, String id_service_, Date paymentDateline_,
            String status_, double total_, String id_);


    @Modifying
    @Query(value = "update " +
            "payment_ " +
            "set delete_status_ = 0, day_delete_ = :dayDelete_ " +
            "where id_ = :idPayment_", nativeQuery = true)
    void deletePayment(@Param("dayDelete_") Date dayDelete_,
                       @Param("idPayment_") String idPayment_);








}
