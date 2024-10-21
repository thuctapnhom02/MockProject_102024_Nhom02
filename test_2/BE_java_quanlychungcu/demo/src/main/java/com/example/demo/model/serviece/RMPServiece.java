package com.example.demo.model.serviece;


import com.example.demo.api_setting.ApiRespone;
import com.example.demo.model.entity.PaymentEntity;
import com.example.demo.model.entity.ServiceEntity;
import com.example.demo.model.entity.TypePaymentEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.repo.PaymentRepo;
import com.example.demo.model.repo.ServiceRepo;
import com.example.demo.model.repo.TypePaymentRepo;
import com.example.demo.model.repo.UserRepo;
import com.example.demo.model.respone.RMPRespone;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class RMPServiece {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    TypePaymentRepo typePaymentRepo;
    @Autowired
    ServiceRepo serviceRepo;

    public ApiRespone<RMPRespone> searchResidentManagementAndPayments(String name_, String phone_, String email_){

        List<UserEntity> userEntities = new ArrayList<>();
        List<TypePaymentEntity> typePaymentEntities = typePaymentRepo.findAll();
        List<ServiceEntity> serviceEntities = serviceRepo.findAll();

        if(name_==null && phone_==null && email_==null){
            userEntities = userRepo.findAll();
        }else{
            userEntities = userRepo.findByNamePhoneEmail(name_,phone_,email_);
        }

        List<PaymentEntity> paymentEntities = new ArrayList<>();

        if(userEntities != null){
            for(UserEntity i : userEntities){
                List<PaymentEntity> paymentEntities1 = paymentRepo.findByIdUser(i.getId_());

                if(paymentEntities1 != null){
                    for(PaymentEntity j : paymentEntities1){
                        paymentEntities.add(j);
                    }
                }
            }
        }

        Double totalProceeds = 0.;
        Double totalReceivables = 0.;

        for(PaymentEntity i : paymentEntities){
            if(i.getStatus_().equals("complete")){
                totalProceeds+=i.getTotal_();
            }else{
                totalReceivables+=i.getTotal_();
            }
        }

        ApiRespone<RMPRespone> apiRespone = new ApiRespone<>();
        apiRespone.setApi_desription_("return to search method");
        apiRespone.setApi_respone_("200");
        apiRespone.setApi_result_(RMPRespone.builder()
                        .payment_(paymentEntities)
                        .user_(userEntities)
                        .service_(serviceEntities)
                        .typePayment_(typePaymentEntities)
                        .totalProceeds(totalProceeds)
                        .totalReceivables(totalReceivables)
                        .build());

        return apiRespone;

    }

}
