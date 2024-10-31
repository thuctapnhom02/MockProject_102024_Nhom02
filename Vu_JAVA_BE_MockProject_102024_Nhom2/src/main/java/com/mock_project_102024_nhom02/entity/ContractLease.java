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
@Table(name = "contract_lease_")
public class ContractLease implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_")
    String id;

    @Column(name = "status_")
    String status;

    @Column(name = "contact_info_")
    String contactInfo;

    @Column(name = "rental_fee_", columnDefinition = "TEXT")
    String rentalFee;

    @Column(name = "payment_period_")
    LocalDate paymentPeriod;

    @Column(name = "lease_start_date_")
    LocalDate leaseStartDate;

    @Column(name = "lease_end_date_")
    LocalDate leaseEndDate;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;

    @ManyToOne
    @JoinColumn(name = "id_user_")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_staff_")
    Staff staff;

    @ManyToOne
    @JoinColumn(name = "id_suppliers_")
    Suppliers suppliers;

    @ManyToOne
    @JoinColumn(name = "id_apartment_")
    Apartment apartment;
}
