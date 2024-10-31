package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mock_project_102024_nhom02.dto.request.ContractServiceRequest;
import com.mock_project_102024_nhom02.dto.response.ContractServiceResponse;
import com.mock_project_102024_nhom02.entity.ContractService;

@Mapper(componentModel = "spring")
public interface ContractServiceMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "suppliers", ignore = true)
    ContractService toContractService(ContractServiceRequest contractServiceRequest);

    ContractServiceResponse toContractServiceResponse(ContractService contractService);

}
