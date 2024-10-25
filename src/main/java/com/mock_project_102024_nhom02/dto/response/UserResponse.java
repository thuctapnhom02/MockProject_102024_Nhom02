package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class UserResponse {
    
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

    LocalDate dayDelete;

    int deleteStatus;
}
