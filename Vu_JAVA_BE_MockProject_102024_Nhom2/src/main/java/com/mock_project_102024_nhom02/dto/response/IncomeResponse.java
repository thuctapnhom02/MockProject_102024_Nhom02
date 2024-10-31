package com.mock_project_102024_nhom02.dto.response;

 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class IncomeResponse {

    
    String id;
 
    String status;
 
    String total;
 
    String paymentDeadline;

    LocalDate dayDelete;

    int deleteStatus;

    UserResponse user;

    ApartmentResponse apartment;

    ServiceResponse service;

    PaymentMethodResponse paymentMethod;

    TypeIncomeResponse typeIncome;
}

