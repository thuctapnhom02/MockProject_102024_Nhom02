package com.mock_project_102024_nhom02.service;

import com.mock_project_102024_nhom02.dto.request.EmploymentContractRequest;
import com.mock_project_102024_nhom02.dto.response.EmploymentContractResponse;

import java.util.List;

public interface EmploymentContractService {
    List<EmploymentContractResponse> getAllEmploymentContracts();
    EmploymentContractResponse getEmploymentContractById(String id);
    EmploymentContractResponse createEmploymentContract(EmploymentContractRequest employmentContractRequest);
    EmploymentContractResponse updateEmploymentContract(EmploymentContractRequest employmentContractRequest, String id);
    void deleteEmploymentContract(String id);
}
