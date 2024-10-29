package com.example.demo.model.repo.bao;

import com.example.demo.model.entity.bao.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffRepo extends JpaRepository<StaffEntity,String> {
    @Query(value = "SELECT * FROM staff_ WHERE phone_ = ?1", nativeQuery = true)
    StaffEntity findByPhone(String phone_);

    @Modifying
    @Query(value = "update staff set id_role_ =  :id_role_  ,name_ =  :name_  ,Phone_ =  :Phone_  ,gender_ =  :gender_  ," +
            "start_day_ =  :start_day_  ,end_day_ =  :end_day_  ,status_ =  :status_  ,password_ =  :password_  ,address_ =  :address_  ," +
            "where id_ = :idStaff_",nativeQuery = true)
    void updateStaff(@Param("idStaff_") String idStaff_);


//    @Modifying
//    @Query(value = "update staff set status_delete_ = 1, day_delete_ = :dayDelete_" +
//            "where id_ = :idStaff_",nativeQuery = true)
//    void deleteStaff(@Param("idStaff_") String idStaff_,
//                     @Param("dayDelete_") String dayDelete_);
}
