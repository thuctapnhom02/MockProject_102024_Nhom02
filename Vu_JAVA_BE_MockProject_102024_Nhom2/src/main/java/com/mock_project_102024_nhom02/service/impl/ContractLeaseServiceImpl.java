package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import com.mock_project_102024_nhom02.dto.request.ContractLeaseRequest;
import com.mock_project_102024_nhom02.dto.response.ContractLeaseResponse;
import com.mock_project_102024_nhom02.service.ContractLeaseService;
import com.mock_project_102024_nhom02.repository.ContractLeaseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContractLeaseServiceImpl implements ContractLeaseService {

    ContractLeaseRepository contractLeaseRepository;

    @Override
    public List<ContractLeaseResponse> getAllContractLease() {
        return List.of();
    }

    @Override
    public ContractLeaseResponse getContractLeaseById(String id) {
        return null;
    }

    @Override
    public ContractLeaseResponse createContractLease(ContractLeaseRequest contractLease) {
        return null;
    }

    @Override
    public ContractLeaseResponse updateContractLease(ContractLeaseRequest contractLease, String id) {
        return null;
    }

    @Override
    public void deleteContractLeaseById(int id) {

    }
}
