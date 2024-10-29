package com.example.demo.model.respone.bao;


import com.example.demo.model.entity.bao.ApartmentEntity;
import com.example.demo.model.entity.bao.PaymentMethodEntity;
import com.example.demo.model.entity.bao.ServiceEntity;
import com.example.demo.model.entity.bao.UserEntity;
import com.example.demo.model.entity.bao.custom.PaymentCustomNameUserEntity;
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
