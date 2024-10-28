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
@Table(name = "utility_contract_")
public class UtilityContract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_contract_")
    String idContract;

    @Column(name = "start_day_")
    LocalDate startDay;

    @Column(name = "end_day_")
    LocalDate endDay;

    @Column(name = "type_of_utility_")
    String typeOfUtility;

    @Column(name = "price_")
    BigDecimal price;

    @Column(name = "status_")
    String status;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;

    @ManyToOne
    @JoinColumn(name = "id_user_")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_suppliers_")
    Suppliers suppliers;

    @ManyToOne
    @JoinColumn(name = "id_staff_")
    Staff staff;
}