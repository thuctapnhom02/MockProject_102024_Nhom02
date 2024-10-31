package com.mock_project_102024_nhom02.dto.request;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class StaffRequest {
    String name;
 
    String phone;
 
    String gender;

    LocalDate startDay;

    String status;

    String password;

    String address;

    String role;
}
