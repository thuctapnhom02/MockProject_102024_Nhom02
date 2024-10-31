package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mock_project_102024_nhom02.dto.request.UtilityContractRequest;
import com.mock_project_102024_nhom02.dto.response.UtilityContractResponse;
import com.mock_project_102024_nhom02.entity.UtilityContract;

@Mapper(componentModel = "spring")
public interface UtilityContractMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "suppliers", ignore = true)
    @Mapping(target = "staff", ignore = true)
    UtilityContract toUtilityContractUtilityContract(UtilityContractRequest utilityContractRequest);

    UtilityContractResponse toUtilityContractResponse(UtilityContract utilityContract);
}
