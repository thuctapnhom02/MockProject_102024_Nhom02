package com.mock_project_102024_nhom02.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.mock_project_102024_nhom02.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    Page<User> findAllByPhoneAndStatus(String name, String status, Pageable pageable);
    Page<User> findAllByStatus(String status, Pageable pageable);
}
