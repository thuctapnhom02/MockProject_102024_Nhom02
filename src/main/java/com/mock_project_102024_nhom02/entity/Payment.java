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
@Table(name = "payment_")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @ManyToOne
    @JoinColumn(name = "user_id_")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_service_")
    Service service;

    @ManyToOne
    @JoinColumn(name = "id_income_")
    Income income;

    @Column(name = "status_")
    String status;

    @Column(name = "total_")
    BigDecimal total;

    @Column(name = "payment_dateline_")
    LocalDate paymentDateline;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;

    @ManyToOne
    @JoinColumn(name = "id_type_payment_")
    TypePayment typePayment;
}
