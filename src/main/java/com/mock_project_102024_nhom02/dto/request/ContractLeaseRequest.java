package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class ContractLeaseRequest  {
 
    String id;
 
    String status; 

    String contactInfo;
 
    String rentalFee; 

    LocalDate paymentPeriod;
 
    LocalDate leaseStartDate;
 
    LocalDate leaseEndDate;
 
    String user;
 
    String staff;
 
    String suppliers;
 
    String apartment;
}
