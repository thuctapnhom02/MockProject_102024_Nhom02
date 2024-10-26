package com.mock_project_102024_nhom02.service;

import com.mock_project_102024_nhom02.dto.request.ContractServiceRequest;
import com.mock_project_102024_nhom02.dto.response.ContractServiceResponse;

import java.util.List;

public interface ContractServiceService {
    ContractServiceResponse getContractServiceById(String id);
    List<ContractServiceResponse> getAllContractService();
    ContractServiceResponse createContractService(ContractServiceRequest contractServiceRequest);
    ContractServiceResponse updateContractService(ContractServiceRequest contractServiceRequest, String id);
    void deleteContractService(String id);
}
