package com.mock_project_102024_nhom02.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.mock_project_102024_nhom02.dto.response.ApiResponse;
import com.mock_project_102024_nhom02.dto.response.ApartmentResponse;
import com.mock_project_102024_nhom02.service.ApartmentService;

@RestController
@RequestMapping("${api.prefix}"+"/apartments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApartmentController {
    ApartmentService apartmentService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse<List<ApartmentResponse>> apiResponse = ApiResponse.<List<ApartmentResponse>>builder()
                .response(HttpStatus.OK.value())
                .message("This is the data of apartment")
                .result(apartmentService.getAllApartments())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
