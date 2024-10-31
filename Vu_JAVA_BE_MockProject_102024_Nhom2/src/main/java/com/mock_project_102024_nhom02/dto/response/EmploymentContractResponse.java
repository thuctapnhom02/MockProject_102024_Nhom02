package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class EmploymentContractResponse  {
  
    String id; 

    String status;
 
    String name;
 
    String phone;
 
    String email;

    LocalDate dayDelete;

    int deleteStatus;
 
    UserResponse user;
 
    StaffResponse staff;
 
    SuppliersResponse suppliers;
}
