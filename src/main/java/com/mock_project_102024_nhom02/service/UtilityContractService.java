package com.mock_project_102024_nhom02.service;

import com.mock_project_102024_nhom02.dto.request.UtilityContractRequest;
import com.mock_project_102024_nhom02.dto.response.UtilityContractResponse;

import java.util.List;

public interface UtilityContractService {
    List<UtilityContractResponse> getAllUtilityContract();
    UtilityContractResponse getUtilityContractById(String utilityContractId);
    UtilityContractResponse createUtilityContract(UtilityContractRequest utilityContractRequest);
    UtilityContractResponse updateUtilityContract(UtilityContractRequest utilityContractRequest, String id);
    void deleteUtilityContractById(String id);
}
