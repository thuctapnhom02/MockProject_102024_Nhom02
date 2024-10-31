package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;

import com.mock_project_102024_nhom02.dto.response.TypeIncomeResponse;
import com.mock_project_102024_nhom02.entity.TypeIncome;

@Mapper(componentModel = "spring")
public interface TypeIncomeMapper {
    TypeIncomeResponse toTypeIncomeResponse(TypeIncome typeIncome);
}
