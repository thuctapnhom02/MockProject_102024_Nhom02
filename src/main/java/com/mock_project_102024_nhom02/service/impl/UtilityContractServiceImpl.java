package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.List;

import com.mock_project_102024_nhom02.dto.request.UtilityContractRequest;
import com.mock_project_102024_nhom02.dto.response.UtilityContractResponse;
import com.mock_project_102024_nhom02.repository.UtilityContractRepository;
import com.mock_project_102024_nhom02.service.UtilityContractService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UtilityContractServiceImpl implements UtilityContractService {

    UtilityContractRepository utilityContractRepository;

    @Override
    public List<UtilityContractResponse> getAllUtilityContract() {
        return List.of();
    }

    @Override
    public UtilityContractResponse getUtilityContractById(String utilityContractId) {
        return null;
    }

    @Override
    public UtilityContractResponse createUtilityContract(UtilityContractRequest utilityContractRequest) {
        return null;
    }

    @Override
    public UtilityContractResponse updateUtilityContract(UtilityContractRequest utilityContractRequest, String id) {
        return null;
    }

    @Override
    public void deleteUtilityContractById(String id) {

    }
}
