package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;

import com.mock_project_102024_nhom02.dto.response.RepairHistoryResponse;
import com.mock_project_102024_nhom02.entity.RepairHistory;

@Mapper(componentModel = "spring")
public interface RepairHistoryMapper {
    RepairHistoryResponse toRepairHistoryResponse(RepairHistory repairHistory);
}
