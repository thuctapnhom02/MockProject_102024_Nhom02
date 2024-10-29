package com.example.demo.model.repo.bao;

import com.example.demo.model.entity.bao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<UserEntity,String> {


    @Query(value = "SELECT  id_,name_,phone_,email_,gender_,ssn_,status_,password_,debt_,total_payment_,start_day_,end_day_,address_, delete_status_, day_delete_ " +
            "FROM user_ " +
            "WHERE name_ like :name_ and phone_ like :phone_ and email_ like :email_ and delete_status_ = 1",nativeQuery = true)

    List<UserEntity> findByNamePhoneEmail(@Param("name_") String name_,
                                          @Param("phone_") String phone_,
                                          @Param("email_") String email_);


    @Query(value = "select id_,name_,phone_,email_,gender_,ssn_,status_,password_,debt_,total_payment_,start_day_,end_day_,address_, delete_status_, day_delete_ " +
            "from user_ " +
            "where delete_status_ = 1 and id_ = :idUser_",nativeQuery = true)
    List<UserEntity> findByIdUser(@Param("idUser_") String idUser_);


    @Modifying
    @Query(value = "UPDATE " +
            "user_ " +
            "SET name_ = ?1, gender_ = ?2, email_ = ?3, start_day_ = ?4, end_day_ = ?5, phone_ = ?6, total_payment_ = ?7, debt_ = ?8, status_ = ?9, password_ = ?10, ssn_ = ?11, address_ = ?12 "+
            "WHERE id_ = ?13 and delete_status_ = 1",nativeQuery = true)
    void updateUser(
            String name, String gender, String email, Date start_day, Date end_day, String phone,
            Double total_payment, Double debt, String status, String password, String ssn, String address, String id);


    @Modifying
    @Query(value = "UPDATE " +
            "user_ " +
            "SET delete_status_ = 0, " +
            "day_delete_ = :dayDelete_ " +
            "where id_ = :idUser_ and delete_status_ = 1",nativeQuery = true)
    void deleteUser(@Param("dayDelete_") Date dateDelete_,
                    @Param("idUser_") String idUser_);


    @Modifying
    @Query(value = "update " +
            "payment_ " +
            "set delete_status_ = 0, day_delete_ = :dayDelete_" +
            "where id_ = :idPayment_ and delete_status_ = 1",nativeQuery = true)
    void deletePayment(@Param("dayDelete_") Date dayDelete_,
                       @Param("idPayment_") String idPayment_);

}






























