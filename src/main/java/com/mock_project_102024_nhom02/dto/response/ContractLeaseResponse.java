package com.mock_project_102024_nhom02.dto.response;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
 
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class ContractLeaseResponse  {
 
    String id;
 
    String status; 

    String contactInfo;
 
    String rentalFee; 

    LocalDate paymentPeriod;
 
    LocalDate leaseStartDate;
 
    LocalDate leaseEndDate;

    LocalDate dayDelete;

    int deleteStatus;
 
    UserResponse user;
 
    StaffResponse staff;
 
    SuppliersResponse suppliers;
 
    ApartmentResponse apartment;
}
