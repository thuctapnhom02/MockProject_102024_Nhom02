package com.mock_project_102024_nhom02.repository;

import com.mock_project_102024_nhom02.entity.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintsRepository extends JpaRepository<Complaints, String> {
}
