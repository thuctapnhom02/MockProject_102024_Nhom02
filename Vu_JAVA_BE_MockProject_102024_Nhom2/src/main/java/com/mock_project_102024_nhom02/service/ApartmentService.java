package com.mock_project_102024_nhom02.service;

import com.mock_project_102024_nhom02.dto.request.ApartmentRequest;
import com.mock_project_102024_nhom02.dto.response.ApartmentResponse;

import java.util.List;

public interface ApartmentService {
    ApartmentResponse addApartment(ApartmentRequest apartment);
    List<ApartmentResponse> getAllApartments();
    ApartmentResponse getApartmentById(String id);
    ApartmentResponse updateApartment(ApartmentRequest apartmentRequest, String id);
    void deleteApartmentById(String id);
}
