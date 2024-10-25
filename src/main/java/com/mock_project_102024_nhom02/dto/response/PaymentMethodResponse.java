package com.mock_project_102024_nhom02.dto.response;
 
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class PaymentMethodResponse  {
 
    String id;
    
    String nameMethod;

    LocalDate dayDelete;

    int deleteStatus;
}
