package com.mock_project_102024_nhom02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mock_project_102024_nhom02.entity.RepairHistory;
@Repository
public interface RepairHistoryRepository extends JpaRepository<RepairHistory, String> {
}
