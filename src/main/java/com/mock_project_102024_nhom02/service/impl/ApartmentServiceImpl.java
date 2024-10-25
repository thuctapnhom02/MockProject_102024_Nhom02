package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.request.ApartmentRequest;
import com.mock_project_102024_nhom02.dto.response.ApartmentResponse;
import com.mock_project_102024_nhom02.service.ApartmentService;
import com.mock_project_102024_nhom02.mapper.ApartmentMapper;
import com.mock_project_102024_nhom02.repository.ApartmentRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApartmentServiceImpl implements ApartmentService {

    ApartmentRepository apartmentRepository;
    ApartmentMapper apartmentMapper;

    @Override
    public ApartmentResponse addApartment(ApartmentRequest apartment) {
        return null;
    }

    @Override
    public List<ApartmentResponse> getAllApartments() {
        return apartmentRepository.findAll()
                .stream().map(apartmentMapper::toApartmentResponse).collect(Collectors.toList());
    }

    @Override
    public ApartmentResponse getApartmentById(String id) {
        return null;
    }

    @Override
    public ApartmentResponse updateApartment(ApartmentRequest apartmentRequest, String id) {
        return null;
    }

    @Override
    public void deleteApartmentById(String id) {

    }
}
