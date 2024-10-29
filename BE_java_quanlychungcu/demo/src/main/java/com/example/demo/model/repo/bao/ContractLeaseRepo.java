package com.example.demo.model.repo.bao;

import com.example.demo.model.entity.bao.ContractLeaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractLeaseRepo extends JpaRepository<ContractLeaseEntity,String> {
}
