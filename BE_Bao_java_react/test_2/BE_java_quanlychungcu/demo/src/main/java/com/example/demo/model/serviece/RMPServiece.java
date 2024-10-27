package com.example.demo.model.serviece;


import com.example.demo.api_setting.ApiRespone;
import com.example.demo.exception.ExceptionCustom;
import com.example.demo.model.entity.*;
import com.example.demo.model.entity.custom.ContractLeaseCustomUserApartmentEntity;
import com.example.demo.model.repo.*;
import com.example.demo.model.repo.custom.ContractLeaseCustomUserApartmentRepo;
import com.example.demo.model.repo.custom.PaymentCustomNameUserRepo;
import com.example.demo.model.request.PaymentUpdateRequest;
import com.example.demo.model.respone.UpdateDeleteCreateRespone;
import com.example.demo.model.request.UserUpdateRequest;
import com.example.demo.model.entity.custom.PaymentCustomNameUserEntity;
import com.example.demo.model.respone.RMPRespone;
import jakarta.persistence.Tuple;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
//@Transactional
public class RMPServiece {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    PaymentMethodRepo paymentMethodRepo;
    @Autowired
    ServiceRepo serviceRepo;
    @Autowired
    ApartmentRepo apartmentRepo;
    @Autowired
    ContractLeaseCustomUserApartmentRepo contractLeaseCustomUserApartmentRepo;
    @Autowired
    PaymentCustomNameUserRepo paymentCustomNameUserRepo;


    public ApiRespone<RMPRespone> searchResidentManagementAndPayments(String name_, String phone_, String email_,String idApartment_){


        /*Search user and payment in user
         *   get value user and payment in user width
         *   name, phone number, email, number apart ment
         * */


        List<UserEntity> userEntities_ = new ArrayList<>();
        List<PaymentMethodEntity> paymentMethodEntities = paymentMethodRepo.findAll();
        List<ServiceEntity> serviceEntities_ = serviceRepo.findAll();
        List<ApartmentEntity> apartmentEntiries_  = apartmentRepo.findAllCustom();
        List<Tuple> tupleCustomPayment_ = new ArrayList<>();

        if(name_==null && phone_==null && email_==null && idApartment_==null){
            userEntities_ = userRepo.findByNamePhoneEmail("%%","%%","%%");
            tupleCustomPayment_ = paymentCustomNameUserRepo.findByNamePhoneEmailUser("%%","%%","%%");
        }else{
            if(idApartment_!=null){
                try {
                    List<Tuple> t = contractLeaseCustomUserApartmentRepo.findByIdApartment(idApartment_);
                    List<ContractLeaseCustomUserApartmentEntity> contractLeaseEntities = t.stream().map(tup -> new ContractLeaseCustomUserApartmentEntity(
                            tup.get(0, String.class),
                            tup.get(1,String.class)
                    )).collect(Collectors.toList());

                    if(contractLeaseEntities!=null){
                        userEntities_ = userRepo.findByIdUser(contractLeaseEntities.get(0).getId_user_());
                        tupleCustomPayment_ = paymentCustomNameUserRepo.findByIdApartMent(idApartment_);
                    }
                } catch (RuntimeException e) {
                    throw new RuntimeException(new ExceptionCustom("not search user and payment","400"));
                }
            }else{
                userEntities_ = userRepo.findByNamePhoneEmail("%"+name_+"%","%"+phone_+"%","%"+email_+"%");
                tupleCustomPayment_ = paymentCustomNameUserRepo.findByNamePhoneEmailUser("%"+name_+"%","%"+phone_+"%","%"+email_+"%");
            }
        }

        List<PaymentCustomNameUserEntity> paymentCustomNameUserEntity = tupleCustomPayment_.stream().map(tup->new PaymentCustomNameUserEntity(
                tup.get("id_",String.class),
                tup.get("name_",String.class),
                tup.get("id_service_",String.class),
                tup.get("id_payment_method_",String.class),
                tup.get("status_",String.class),
                tup.get("total_",Double.class),
                tup.get("payment_dateline_",Date.class)
        )).collect(Collectors.toList());

        Double totalProceeds_ = 0.;
        Double totalReceivables_ = 0.;

        for(PaymentCustomNameUserEntity i : paymentCustomNameUserEntity){
            if(i.getStatus_().equals("complete")){
                totalProceeds_+=i.getTotal_();
            }else{
                totalReceivables_+=i.getTotal_();
            }
        }

        ApiRespone<RMPRespone> apiRespone = ApiRespone.<RMPRespone>builder()
                .api_desription_("return to search method")
                .api_respone_("200")
                .api_result_(RMPRespone.builder()
                        .payment_(paymentCustomNameUserEntity)
                        .user_(userEntities_)
                        .service_(serviceEntities_)
                        .paymentMethod_(paymentMethodEntities)
                        .apartmentEntiries_(apartmentEntiries_)
                        .totalProceeds_(totalProceeds_)
                        .totalReceivables_(totalReceivables_)
                        .build())
                .build();

        return apiRespone;
    }


    public ApiRespone<UpdateDeleteCreateRespone> updateRMPUser(UserEntity userEntityRequest_){


        /*update the user table
         * update and check err user table
         * */


        try {
            userEntityRequest_.setDelete_status_(1);
            userRepo.save(userEntityRequest_);
            ApiRespone<UpdateDeleteCreateRespone> apiRespone = ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("Update payment user"+userEntityRequest_.getId_())
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_("update submit a user data")
                            .check_(true)
                            .build())
                    .build();

            return apiRespone;
        } catch (Exception e) {
            ApiRespone<UpdateDeleteCreateRespone> apiRespone = ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("Update payment user"+userEntityRequest_.getId_())
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_(e.toString())
                            .check_(false)
                            .build())
                    .build();

            return apiRespone;
        }



    }


    public ApiRespone<UpdateDeleteCreateRespone> upDateRMPPayment(PaymentEntity paymentEntity){


        /*Update the payment table
         * update and check err user table
         * */


        try {
            paymentEntity.setDelete_status_(1);
            paymentRepo.updatePayment(paymentEntity.getId_payment_method_(),
                    paymentEntity.getId_service_(),
                    paymentEntity.getPayment_dateline_(),
                    paymentEntity.getStatus_(),
                    paymentEntity.getTotal_(),
                    paymentEntity.getId_());
            ApiRespone<UpdateDeleteCreateRespone> apiRespone = ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("Update payment request"+paymentEntity.getId_())
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_("update submit a user data")
                            .check_(true)
                            .build())
                    .build();

            return new ApiRespone<>();
        } catch (Exception e) {
            ApiRespone<UpdateDeleteCreateRespone> apiRespone = ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("Update payment request err"+paymentEntity.getId_())
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_(e.toString())
                            .check_(false)
                            .build())
                    .build();

            return apiRespone;
        }
    }


    public ApiRespone<UpdateDeleteCreateRespone> deleteUser(String id_user_){


        /*delete user tabel
        *   change state collum delete status to 0 => delete state
        *   and set date delete
        * */


        try {
            userRepo.deleteUser(new Date(),id_user_);

            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("delete user request")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .check_(true)
                            .desription_("delete submit")
                            .build())
                    .build();
        } catch (Exception e) {
            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("delete user request err")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .check_(true)
                            .desription_(e.toString())
                            .build())
                    .build();
        }
    }


    public ApiRespone<UpdateDeleteCreateRespone> deletePayment(String id_payment_){


        /*delete payment tabel
         *   change state collum delete status to 0 => delete state
         *   and set date delete
         * */


        try {
            System.out.println(id_payment_);
            paymentRepo.deletePayment(new Date(),id_payment_);

            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("delete payment request")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .check_(true)
                            .desription_("delete submit")
                            .build())
                    .build();
        } catch (Exception e) {
            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("delete payment request err")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .check_(true)
                            .desription_(e.toString())
                            .build())
                    .build();
        }

    }


    public ApiRespone<UpdateDeleteCreateRespone> createUser(UserEntity userEntityRequest_){


        /*create data user infomation
        *   create 1 row data user in tabel user_
        *
        * */


        try {
            userEntityRequest_.setDelete_status_(1);
            userRepo.save(userEntityRequest_);
            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("create user request")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_("create user sunmit")
                            .check_(true)
                            .build())
                    .build();
        } catch (Exception e) {
            return ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("create user request err!!")
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_(e.toString())
                            .check_(false)
                            .build())
                    .build();
        }
    }














}
