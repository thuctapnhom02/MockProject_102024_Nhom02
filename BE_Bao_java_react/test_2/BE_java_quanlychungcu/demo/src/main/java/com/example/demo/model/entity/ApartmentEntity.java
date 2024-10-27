package com.example.demo.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "apartment_")
public class ApartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    Integer delete_status_;
    Date day_delete_;
    Integer flor_;
    String status_;
    String num_apartment_;
    String num_bedroom_;
    Double square_;
    Double rent_price_;
    String address_;
//    String address_;
}

