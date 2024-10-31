package com.mock_project_102024_nhom02.dto.response;
 
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class StaffResponse {
    String id;

    String name;

    String phone;

    String gender;

    LocalDate startDay;

    LocalDate endDay;

    String status;

    String password;

    String address;

    LocalDate dayDelete;

    int deleteStatus;

    RoleResponse role;


}
