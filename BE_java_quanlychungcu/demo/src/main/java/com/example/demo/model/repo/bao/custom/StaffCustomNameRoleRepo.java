package com.example.demo.model.repo.bao.custom;

import com.example.demo.model.entity.bao.StaffEntity;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffCustomNameRoleRepo extends CrudRepository<StaffEntity,String> {

    @Query(value = "select s.id_,s.name_,s.phone_,s.gender_,s.start_day_,s.end_day_,s.status_,s.password_,s.address_,r.id_ as id_role_,r.name_role_ " +
            "from staff_ s , role_ r " +
            "where s.id_role_ = r.id_ and s.name_ like :nameStaff_ and s.status_ like :status_ and s.delete_status_ = 1",nativeQuery = true)
    List<Tuple> findByNameAndStatus(@Param("nameStaff_") String nameStaff_,
                                    @Param("status_") String status_);
}
