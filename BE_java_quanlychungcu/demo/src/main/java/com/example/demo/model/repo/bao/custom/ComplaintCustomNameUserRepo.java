package com.example.demo.model.repo.bao.custom;

import com.example.demo.model.entity.bao.ComplaintEntity;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComplaintCustomNameUserRepo extends JpaRepository<ComplaintEntity,String> {



    @Query(value = "select c.id_, u.name_ , c.status_, c.complaint_date_, c.expected_completion_date_, c.content_of_complaint_ , c.note_ ,c.id_apartment_, a.num_apartment_, c.id_staff_ " +
            "from user_ u, complaints_ c ,apartment_ a " +
            "where u.id_ = c.id_user_ and u.name_ like :nameUser_ and a.id_ = c.id_apartment_ and c.status_ like :status_",nativeQuery = true)
    List<Tuple> findByNameUserAndStatus(@Param("nameUser_") String nameUser_,
                                        @Param("status_") String status_);


    @Query(value = "select c.id_, u.name_ , c.status_, c.complaint_date_, c.expected_completion_date_, c.content_of_complaint_ , c.note_ ,c.id_apartment_, a.num_apartment_ ,c.id_staff_ " +
            "from user_ u, complaints_ c ,apartment_ a " +
            "where u.id_ = c.id_user_ and c.id_ = :idComplaint_ and a.id_ = c.id_apartment_",nativeQuery = true)
    List<Tuple> findByIDComplaint(@Param("idComplaint_") String idComplaint_);



}
