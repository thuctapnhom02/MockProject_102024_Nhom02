package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.List;

import com.mock_project_102024_nhom02.dto.request.ContractServiceRequest;
import com.mock_project_102024_nhom02.dto.response.ContractServiceResponse;
import com.mock_project_102024_nhom02.repository.ContractServiceRepository;
import com.mock_project_102024_nhom02.service.ContractServiceService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContractServiceServiceImpl implements ContractServiceService {

    ContractServiceRepository contractServiceRepository;

    @Override
    public ContractServiceResponse getContractServiceById(String id) {
        return null;
    }

    @Override
    public List<ContractServiceResponse> getAllContractService() {
        return List.of();
    }

    @Override
    public ContractServiceResponse createContractService(ContractServiceRequest contractServiceRequest) {
        return null;
    }

    @Override
    public ContractServiceResponse updateContractService(ContractServiceRequest contractServiceRequest, String id) {
        return null;
    }

    @Override
    public void deleteContractService(String id) {

    }
}
