package com.example.demo.model.repo.custom;

import com.example.demo.model.entity.custom.ContractLeaseCustomUserApartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractLeaseCustomUserApartmentRepo extends JpaRepository<ContractLeaseCustomUserApartmentEntity,String> {

    @Query(value = "select c.id_user_,c.id_apartment_ " +
            "from user_ u,contract_lease_ c, apartment_ a " +
            "where c.id_apartment_ = :idApartment_ and u.id_ = c.id_user_ and c.id_apartment_ = a.id_ and a.delete_status_ = 1",nativeQuery = true)
    ContractLeaseCustomUserApartmentEntity findByIdApartment(@Param("idApartment_") String idApartment_);
}
