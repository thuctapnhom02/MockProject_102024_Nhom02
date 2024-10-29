package com.example.demo.model.repo.bao;

import com.example.demo.model.entity.bao.ComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ComplaintRepo extends JpaRepository<ComplaintEntity,String> {

    @Modifying
    @Query(value = "Update complaints_ " +
            "set status_ = :status_ , id_staff_ = :idStaff_ " +
            "where id_ = :idComplaint_",nativeQuery = true)
    void updateCompalaint(@Param("status_") String status_,
                          @Param("idComplaint_") String idComplaint_,
                          @Param("idStaff_") String idStaff_);
}
