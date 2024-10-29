package com.example.demo.model.entity.bao.custom;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContractLeaseCustomUserApartmentEntity {
    String id_user_;
    String id_apartment_;
}
