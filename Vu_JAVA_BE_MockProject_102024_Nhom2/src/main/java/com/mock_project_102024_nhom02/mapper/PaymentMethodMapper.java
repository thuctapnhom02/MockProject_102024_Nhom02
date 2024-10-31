package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;

import com.mock_project_102024_nhom02.dto.response.PaymentMethodResponse;
import com.mock_project_102024_nhom02.entity.PaymentMethod;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
    PaymentMethodResponse toPaymentMethodResponse(PaymentMethod paymentMethod);
}
