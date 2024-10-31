package com.mock_project_102024_nhom02.dto.request;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class SuppliersRequest{
 
    String id;
 
    String name;
 
    String phone;
    
    String address;

}

