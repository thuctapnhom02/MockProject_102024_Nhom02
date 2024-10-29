package com.example.demo.model.repo.bao;

import com.example.demo.model.entity.bao.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<ServiceEntity,String> {
}
