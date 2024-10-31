package com.mock_project_102024_nhom02.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mock_project_102024_nhom02.entity.Role;
import com.mock_project_102024_nhom02.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
    boolean existsByPhone(String phone);

    Page<Staff> findAllByPhoneAndStatusAndRole(String phone, String status, Role role, Pageable pageable);
    Page<Staff> findAllByStatus(String status, Pageable pageable);
}
