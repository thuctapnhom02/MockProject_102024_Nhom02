package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class SuppliersResponse{
 
    String id;
 
    String name;
 
    String phone;
    
    String address;

    LocalDate dayDelete;

    int deleteStatus;

}

