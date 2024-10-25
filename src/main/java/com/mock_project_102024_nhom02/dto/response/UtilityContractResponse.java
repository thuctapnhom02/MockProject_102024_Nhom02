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
public class UtilityContractResponse {
  
    String idContract;
 
    LocalDate startDay;
 
    LocalDate endDay;
 
    String typeOfUtility;
 
    BigDecimal price;
 
    String status;

    LocalDate dayDelete;

    int deleteStatus;
 
    UserResponse user;
 
    SuppliersResponse suppliers;
 
    StaffResponse staff;
}
