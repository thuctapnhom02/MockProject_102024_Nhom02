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
import com.mock_project_102024_nhom02.dto.response.PaymentMethodResponse;
import com.mock_project_102024_nhom02.service.PaymentMethodService;

@RestController
@RequestMapping("${api.prefix}"+"/payment-methods")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentMethodController {
    PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse<List<PaymentMethodResponse>> apiResponse = ApiResponse.<List<PaymentMethodResponse>>builder()
                .response(HttpStatus.OK.value())
                .message("This is the data of payment method")
                .result(paymentMethodService.getAllPaymentMethods())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
