package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mock_project_102024_nhom02.dto.request.EmploymentContractRequest;
import com.mock_project_102024_nhom02.dto.response.EmploymentContractResponse;
import com.mock_project_102024_nhom02.entity.EmploymentContract;

@Mapper(componentModel = "spring")
public interface EmploymentContractMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "suppliers", ignore = true)
    EmploymentContract toEmploymentContract(EmploymentContractRequest employmentContractRequest);

    EmploymentContractResponse toEmploymentContractResponse(EmploymentContract employmentContract);
}
