package com.example.demo.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "type_payment_")
public class TypePaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    String name_type_;
}
