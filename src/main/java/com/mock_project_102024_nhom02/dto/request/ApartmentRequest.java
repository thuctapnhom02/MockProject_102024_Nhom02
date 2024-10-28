package com.mock_project_102024_nhom02.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class ApartmentRequest {

    String id;

    Integer flor;

    String status;

    String numApartment;

    Integer numBedroom;

    BigDecimal square;

    BigDecimal rentPrice;

    String address;


}
