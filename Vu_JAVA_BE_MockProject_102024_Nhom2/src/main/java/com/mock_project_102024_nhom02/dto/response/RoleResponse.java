package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class RoleResponse { 
    
    String id;
 
    String nameRole;

    LocalDate dayDelete;

    int deleteStatus;
}
