package com.example.demo.model.respone;


import com.example.demo.model.entity.*;
import com.example.demo.model.entity.custom.PaymentCustomNameUserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RMPRespone {
    List<UserEntity> user_;
    List<PaymentCustomNameUserEntity> payment_;
    List<ServiceEntity> service_;
//    List<String> nameUserToPayment_;
    List<PaymentMethodEntity> paymentMethod_;
    List<ApartmentEntity> apartmentEntiries_;
    double totalReceivables_;
    double totalProceeds_;
}
