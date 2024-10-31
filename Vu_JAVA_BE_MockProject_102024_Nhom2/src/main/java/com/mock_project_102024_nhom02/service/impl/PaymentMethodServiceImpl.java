package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.response.PaymentMethodResponse;
import com.mock_project_102024_nhom02.mapper.PaymentMethodMapper;
import com.mock_project_102024_nhom02.repository.PaymentMethodRepository;
import com.mock_project_102024_nhom02.service.PaymentMethodService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentMethodServiceImpl implements PaymentMethodService {

    PaymentMethodRepository paymentMethodRepository;
    PaymentMethodMapper paymentMethodMapper;

    @Override
    public List<PaymentMethodResponse> getAllPaymentMethods() {
        return paymentMethodRepository.findAll()
                .stream().map(paymentMethodMapper::toPaymentMethodResponse).collect(Collectors.toList());
    }
}
