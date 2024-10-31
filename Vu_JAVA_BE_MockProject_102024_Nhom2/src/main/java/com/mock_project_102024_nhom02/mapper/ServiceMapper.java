package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;

import com.mock_project_102024_nhom02.dto.response.ServiceResponse;
import com.mock_project_102024_nhom02.entity.Service;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceResponse toServiceResponse(Service service);
}
