package com.mock_project_102024_nhom02.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "income_")
public class Income implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @Column(name = "status_")
    String status;

    @Column(name = "total_")
    String total;

    @Column(name = "payment_deadline_")
    LocalDate paymentDeadline;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;

    @ManyToOne
    @JoinColumn(name = "id_user_")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_apartment_")
    Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "id_service_")
    Service service;

    @ManyToOne
    @JoinColumn(name = "id_payment_method_")
    PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "id_type_income_")
    TypeIncome typeIncome;
}

