package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.response.SuppliersResponse;
import com.mock_project_102024_nhom02.mapper.SupplierMapper;
import com.mock_project_102024_nhom02.repository.SuppliersRepository;
import com.mock_project_102024_nhom02.service.SuppliersService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplierServiceImpl implements SuppliersService {

    SuppliersRepository suppliersRepository;
    SupplierMapper supplierMapper;

    @Override
    public List<SuppliersResponse> getAllSuppliers() {
        return suppliersRepository.findAll()
                .stream().map(supplierMapper::toSuppliersResponse).collect(Collectors.toList());
    }
}
