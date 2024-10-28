package com.mock_project_102024_nhom02.dto.request;
 
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class EmploymentContractRequest  {
  
    String id; 

    String status;
 
    String name;
 
    String phone;
 
    String email;
 
    String user;
 
    String staff;
 
    String suppliers;
}
