package com.mock_project_102024_nhom02.dto.request;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class UtilityContractRequest {
  
    String idContract;
 
    LocalDate startDay;
 
    LocalDate endDay;
 
    String typeOfUtility;
 
    BigDecimal price;
 
    String status;
 
    String user;
 
    String suppliers;
 
    String staff;
}
