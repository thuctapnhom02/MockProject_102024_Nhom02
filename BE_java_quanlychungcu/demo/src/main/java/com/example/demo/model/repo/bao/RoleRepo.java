package com.example.demo.model.repo.bao;

import com.example.demo.model.entity.bao.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface RoleRepo extends JpaRepository<RoleEntity,String> {
    @Query(value = "SELECT * FROM role_ WHERE id_ = ?1", nativeQuery = true)
    RoleEntity findById_(String phone_);

}
