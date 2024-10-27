package com.example.demo.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "payment_")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    String user_id_;
    String id_service_;
    String id_income_;
    String status_;
    Double total_;
    Date payment_dateline_;
    String id_payment_method_;
    Integer delete_status_;
    Date day_delete_;

}
