package com.mock_project_102024_nhom02.service;

import com.mock_project_102024_nhom02.dto.request.ContractLeaseRequest;
import com.mock_project_102024_nhom02.dto.response.ContractLeaseResponse;

import java.util.List;

public interface ContractLeaseService {
    List<ContractLeaseResponse> getAllContractLease();
    ContractLeaseResponse getContractLeaseById(String id);
    ContractLeaseResponse createContractLease(ContractLeaseRequest contractLease);
    ContractLeaseResponse updateContractLease(ContractLeaseRequest contractLease, String id);
    void deleteContractLeaseById(int id);
}
