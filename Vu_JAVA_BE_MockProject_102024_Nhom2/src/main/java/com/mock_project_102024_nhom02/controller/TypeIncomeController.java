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

import com.mock_project_102024_nhom02.dto.response.TypeIncomeResponse;
import com.mock_project_102024_nhom02.dto.response.ApiResponse;
import com.mock_project_102024_nhom02.service.TypeIncomeService;

@RestController
@RequestMapping("${api.prefix}"+"/type-incomes")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeIncomeController {
    TypeIncomeService typeIncomeService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse<List<TypeIncomeResponse>> apiResponse = ApiResponse.<List<TypeIncomeResponse>>builder()
                .response(HttpStatus.OK.value())
                .message("This is the data of type income")
                .result(typeIncomeService.getAllTypeIncome())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
