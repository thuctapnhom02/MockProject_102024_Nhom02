package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.response.ServiceResponse;
import com.mock_project_102024_nhom02.mapper.ServiceMapper;
import com.mock_project_102024_nhom02.repository.ServiceRepository;
import com.mock_project_102024_nhom02.service.ServiceService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServiceServiceImpl implements ServiceService {

    ServiceRepository serviceRepository;
    ServiceMapper serviceMapper;

    @Override
    public List<ServiceResponse> getAllServices() {
        return serviceRepository.findAll()
                .stream().map(serviceMapper::toServiceResponse).collect(Collectors.toList());
    }
}
