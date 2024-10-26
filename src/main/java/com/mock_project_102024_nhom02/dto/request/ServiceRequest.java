package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class ServiceRequest{
  
    String id;
 
    String name;
 
    BigDecimal price;
 
    String regulation;
 
    String description;
}

