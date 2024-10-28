package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.List;

import com.mock_project_102024_nhom02.dto.request.EmploymentContractRequest;
import com.mock_project_102024_nhom02.dto.response.EmploymentContractResponse;
import com.mock_project_102024_nhom02.service.EmploymentContractService;
import com.mock_project_102024_nhom02.repository.EmploymentContractRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmploymentContractServiceImpl implements EmploymentContractService {

    EmploymentContractRepository employmentContractRepository;

    @Override
    public List<EmploymentContractResponse> getAllEmploymentContracts() {
        return List.of();
    }

    @Override
    public EmploymentContractResponse getEmploymentContractById(String id) {
        return null;
    }

    @Override
    public EmploymentContractResponse createEmploymentContract(EmploymentContractRequest employmentContractRequest) {
        return null;
    }

    @Override
    public EmploymentContractResponse updateEmploymentContract(EmploymentContractRequest employmentContractRequest, String id) {
        return null;
    }

    @Override
    public void deleteEmploymentContract(String id) {

    }
}
