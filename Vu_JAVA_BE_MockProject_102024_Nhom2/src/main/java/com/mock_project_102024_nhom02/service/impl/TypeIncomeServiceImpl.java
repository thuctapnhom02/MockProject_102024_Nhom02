package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.response.TypeIncomeResponse;
import com.mock_project_102024_nhom02.mapper.TypeIncomeMapper;
import com.mock_project_102024_nhom02.repository.TypeIncomeRepository;
import com.mock_project_102024_nhom02.service.TypeIncomeService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeIncomeServiceImpl implements TypeIncomeService {

    TypeIncomeRepository typeIncomeRepository;
    TypeIncomeMapper typeIncomeMapper;

    @Override
    public List<TypeIncomeResponse> getAllTypeIncome() {
        return typeIncomeRepository.findAll()
                .stream().map(typeIncomeMapper::toTypeIncomeResponse).collect(Collectors.toList());
    }
}
