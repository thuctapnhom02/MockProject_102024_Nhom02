package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;
 
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class RentalRequestResponse {
 
    String id;
 
    ApartmentResponse apartment; 

    String tenantName; 

    LocalDate dateOfBirth;
 
    String address;
 
    String phone;
 
    String email;
 
    String job;
 
    String status;

    LocalDate dayDelete;

    int deleteStatus;
}

