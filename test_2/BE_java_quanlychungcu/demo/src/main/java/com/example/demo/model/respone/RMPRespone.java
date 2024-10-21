package com.example.demo.model.respone;


import com.example.demo.model.entity.PaymentEntity;
import com.example.demo.model.entity.ServiceEntity;
import com.example.demo.model.entity.TypePaymentEntity;
import com.example.demo.model.entity.UserEntity;
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
    List<PaymentEntity> payment_;
    List<ServiceEntity> service_;
    List<TypePaymentEntity> typePayment_;
    double totalReceivables;
    double totalProceeds;
}
