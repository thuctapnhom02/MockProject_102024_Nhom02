package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "contract_lease_")
public class ContractLeaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_;
    String id_user_;
    String id_staff_;
    String status_;
    String contact_info_;
    String rental_fee_;
    Date payment_period_;
    Date lease_start_date_;
    Date lease_end_date_;
    String id_suppliers_;
    String id_apartment_;
    Integer delete_status_;
    Date day_delete_;
}
