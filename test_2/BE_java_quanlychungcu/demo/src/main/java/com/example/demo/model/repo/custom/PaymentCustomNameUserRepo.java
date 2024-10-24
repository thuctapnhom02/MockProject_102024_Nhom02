package com.example.demo.model.repo.custom;

import com.example.demo.model.entity.custom.PaymentCustomNameUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentCustomNameUserRepo extends JpaRepository<PaymentCustomNameUserEntity,String> {
    @Query(value = "SELECT p.id_, p.id_service_, p.id_payment_method_, p.status_, p.total_, p.payment_dateline_, u.name_ " +
            "FROM payment_ p, user_ u " +
            "WHERE  u.id_ = p.user_id_ and u.name_ like ?1 and u.phone_ like ?2 and u.email_ like ?3 and p.delete_status_ = 1",nativeQuery = true)
    List<PaymentCustomNameUserEntity> findByNamePhoneEmailUser(String name_, String phone_, String email_);


    @Query(value = "SELECT p.id_, p.id_service_, p.id_payment_method_, p.status_, p.total_, p.payment_dateline_, u.name_ "+
            "FROM payment_ p, contract_lease_ c, user_ u " +
            "WHERE  c.id_apartment_ = :idApartMent_ and c.id_user_ = p.user_id_  and p.delete_status_ = 1 and  u.id_ = c.id_user_ "
            ,nativeQuery = true)
    List<PaymentCustomNameUserEntity> findByIdApartMent(@Param("idApartMent_") String idApartMent_);
}
