package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;

import com.mock_project_102024_nhom02.dto.response.SuppliersResponse;
import com.mock_project_102024_nhom02.entity.Suppliers;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SuppliersResponse toSuppliersResponse(Suppliers Suppliers);
}
