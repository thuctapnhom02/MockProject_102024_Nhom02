package com.mock_project_102024_nhom02.repository;

import com.mock_project_102024_nhom02.entity.Complaints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintsRepository extends JpaRepository<Complaints, String> {
    Page<Complaints> findAllByIdLikeAndStatus(String id, String status, Pageable pageable);
    Page<Complaints> findAllByIdLike(String id, Pageable pageable);
    Page<Complaints> findAllByStatus(String status, Pageable pageable);
}
