package com.mock_project_102024_nhom02.dto.request;
 
import lombok.*;
import lombok.experimental.FieldDefaults;
 

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class UserRequest {
    
    String id;
 
    String name;
 
    String email;
 
    String phone;
 
    String gender;
 
    String ssn;
 
    String status;
 
    String password;
 
    String debt;
 
    String total_payment;

}
