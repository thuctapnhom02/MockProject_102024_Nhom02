package com.example.demo.model.repo;

import com.example.demo.model.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<ServiceEntity,String> {
}
