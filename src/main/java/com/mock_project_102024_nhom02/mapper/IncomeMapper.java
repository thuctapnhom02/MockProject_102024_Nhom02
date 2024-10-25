package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.mock_project_102024_nhom02.dto.request.IncomeRequest;
import com.mock_project_102024_nhom02.dto.response.IncomeResponse;
import com.mock_project_102024_nhom02.entity.Income;

@Mapper(componentModel = "spring")
public interface IncomeMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "apartment", ignore = true)
    @Mapping(target = "service", ignore = true)
    @Mapping(target = "paymentMethod", ignore = true)
    @Mapping(target = "typeIncome", ignore = true)
    Income toIncome(IncomeRequest incomeRequest);

    IncomeResponse toIncomeResponse(Income income);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "apartment", ignore = true)
    @Mapping(target = "service", ignore = true)
    @Mapping(target = "paymentMethod", ignore = true)
    @Mapping(target = "typeIncome", ignore = true)
    void updateIncome(@MappingTarget Income income, IncomeRequest request);

}

