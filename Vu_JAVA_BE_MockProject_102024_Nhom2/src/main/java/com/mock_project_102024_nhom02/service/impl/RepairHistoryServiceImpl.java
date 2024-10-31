package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.response.RepairHistoryResponse;
import com.mock_project_102024_nhom02.mapper.RepairHistoryMapper;
import com.mock_project_102024_nhom02.repository.RepairHistoryRepository;
import com.mock_project_102024_nhom02.service.RepairHistoryService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RepairHistoryServiceImpl implements RepairHistoryService {

    RepairHistoryRepository repairHistoryRepository;
    RepairHistoryMapper repairHistoryMapper;

    @Override
    public List<RepairHistoryResponse> getAllRepairHistory() {
        return repairHistoryRepository.findAll()
                .stream().map(repairHistoryMapper::toRepairHistoryResponse).collect(Collectors.toList());
    }
}
