package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;
 
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class PaymentResponse {
 
    String id;
 
    UserResponse user;
 
    ServiceResponse service;
 
    IncomeResponse income; 

    String status;

    LocalDate dayDelete;

    int deleteStatus;
 
    BigDecimal total;
 
    LocalDate paymentDateline;
 
    TypePaymentResponse typePayment;
}
