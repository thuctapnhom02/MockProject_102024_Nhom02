package com.example.demo.model.entity.custom;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "contract_lease_custom_user_apartment_entity_")
public class ContractLeaseCustomUserApartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id_user_;
    String id_apartment_;
}
