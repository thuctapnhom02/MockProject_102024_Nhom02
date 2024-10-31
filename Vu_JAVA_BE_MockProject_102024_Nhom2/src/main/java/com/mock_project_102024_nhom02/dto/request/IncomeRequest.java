package com.mock_project_102024_nhom02.dto.request;

 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class IncomeRequest {

    String user;
 
    String apartment;
 
    String status; 

    String service;
 
    String paymentMethod;
 
    String total;
 
    LocalDate paymentDeadline;
 
    String typeIncome;
}

