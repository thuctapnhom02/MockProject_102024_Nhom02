package com.example.demo.model.request.bao;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentUpdateRequest {
    String id_;
    String idPaymentMethod_;
    String idService_;
    Date paymentDateline_;
    String Status_;
    double total_;
}
