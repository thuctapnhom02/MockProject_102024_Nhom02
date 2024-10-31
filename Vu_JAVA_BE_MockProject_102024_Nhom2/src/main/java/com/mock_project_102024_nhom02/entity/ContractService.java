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
@Table(name = "contract_service_")
public class ContractService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_contract_")
    String idContract;

    @Column(name = "start_contract_")
    LocalDate startContract;

    @Column(name = "end_contract_")
    LocalDate endContract;

    @Column(name = "scope_of_the_contract_")
    String scopeOfTheContract;

    @Column(name = "quality_standards_")
    String qualityStandards;

    @Column(name = "day_delete_")
    LocalDate dayDelete;

    @Column(name = "delete_status_")
    int deleteStatus;

    @Column(name = "status_")
    String status;

    @ManyToOne
    @JoinColumn(name = "id_user_")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_staff_")
    Staff staff;

    @ManyToOne
    @JoinColumn(name = "id_suppliers_")
    Suppliers suppliers;
}

