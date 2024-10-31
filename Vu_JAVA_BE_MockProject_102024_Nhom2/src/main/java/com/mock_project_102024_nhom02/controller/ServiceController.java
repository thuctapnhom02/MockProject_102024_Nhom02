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

import com.mock_project_102024_nhom02.dto.response.ServiceResponse;
import com.mock_project_102024_nhom02.dto.response.ApiResponse;
import com.mock_project_102024_nhom02.service.ServiceService;

@RestController
@RequestMapping("${api.prefix}"+"/services")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServiceController {
    ServiceService serviceService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse<List<ServiceResponse>> apiResponse = ApiResponse.<List<ServiceResponse>>builder()
                .response(HttpStatus.OK.value())
                .message("This is the data of service")
                .result(serviceService.getAllServices())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
