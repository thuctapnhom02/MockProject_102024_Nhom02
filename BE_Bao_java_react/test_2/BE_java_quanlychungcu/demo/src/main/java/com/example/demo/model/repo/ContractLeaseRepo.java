package com.example.demo.model.repo;

import com.example.demo.model.entity.ContractLeaseEntity;
import com.example.demo.model.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractLeaseRepo extends JpaRepository<ContractLeaseEntity,String> {
}
