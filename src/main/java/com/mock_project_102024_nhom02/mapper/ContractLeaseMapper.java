package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mock_project_102024_nhom02.dto.request.ContractLeaseRequest;
import com.mock_project_102024_nhom02.dto.response.ContractLeaseResponse;
import com.mock_project_102024_nhom02.entity.ContractLease;

@Mapper(componentModel = "spring")
public interface ContractLeaseMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "suppliers", ignore = true)
    @Mapping(target = "apartment", ignore = true)
    ContractLease toContractLease(ContractLeaseRequest request);

    ContractLeaseResponse toContractLeaseResponse(ContractLease contractLease);
}
