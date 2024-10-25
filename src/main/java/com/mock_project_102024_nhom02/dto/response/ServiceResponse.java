package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;
 
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class ServiceResponse{
  
    String id;
 
    String name;
 
    BigDecimal price;
 
    String regulation;
 
    String description;

    LocalDate dayDelete;

    int deleteStatus;
}

