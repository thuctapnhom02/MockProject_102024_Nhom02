package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;

import com.mock_project_102024_nhom02.dto.response.ApartmentResponse;
import com.mock_project_102024_nhom02.entity.Apartment;

@Mapper(componentModel = "spring")
public interface ApartmentMapper {
    ApartmentResponse toApartmentResponse(Apartment apartment);
}
