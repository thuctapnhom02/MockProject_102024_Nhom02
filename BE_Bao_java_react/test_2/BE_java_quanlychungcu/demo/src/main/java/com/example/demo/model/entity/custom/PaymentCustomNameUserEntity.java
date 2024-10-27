package com.example.demo.model.entity.custom;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentCustomNameUserEntity {
    String id_;
    String name_;
    String id_service_;
    String id_payment_method_;
    String status_;
    Double total_;
    Date payment_dateline_;
}
