package com.mock_project_102024_nhom02.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "apartment_")
public class Apartment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @Column(name = "flor_")
    int flor;

    @Column(name = "status_")
    String status;

    @Column(name = "num_apartment_")
    String numApartment;

    @Column(name = "num_bedroom_")
    int numBedroom;

    @Column(name = "square_")
    BigDecimal square;

    @Column(name = "rent_price_")
    BigDecimal rentPrice;

    @Column(name = "address_")
    String address;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;

}
