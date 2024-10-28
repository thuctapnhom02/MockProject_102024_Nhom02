package com.mock_project_102024_nhom02.service;


import java.util.List;

import com.mock_project_102024_nhom02.dto.response.PaymentMethodResponse;

public interface PaymentMethodService {
    List<PaymentMethodResponse> getAllPaymentMethods();
}
