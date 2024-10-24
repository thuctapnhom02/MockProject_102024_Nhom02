package com.example.demo.model.serviece;


import com.example.demo.api_setting.ApiRespone;
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
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<PaymentCustomNameUserEntity> paymentCustomNameUserEntities = new ArrayList<>();

        if(name_==null && phone_==null && email_==null && idApartment_==null){
            userEntities_ = userRepo.findByNamePhoneEmail("%%","%%","%%");
            paymentCustomNameUserEntities = paymentCustomNameUserRepo.findByNamePhoneEmailUser("%%","%%","%%");
        }else{
            if(idApartment_!=null){
                ContractLeaseCustomUserApartmentEntity contractLeaseEntities = contractLeaseCustomUserApartmentRepo.findByIdApartment(idApartment_);
                System.out.println(contractLeaseEntities);
                if(contractLeaseEntities!=null){
                    userEntities_ = userRepo.findByIdUser(contractLeaseEntities.getId_user_());
                    paymentCustomNameUserEntities = paymentCustomNameUserRepo.findByIdApartMent(idApartment_);
                    System.out.println(userEntities_);
//                    paymentCustomNameUserEntities = paymentCustomNameUserRepo.findByNamePhoneEmailUser("%"+name_+"%","%"+phone_+"%","%"+email_+"%");
                }
            }else{
                userEntities_ = userRepo.findByNamePhoneEmail("%"+name_+"%","%"+phone_+"%","%"+email_+"%");
                paymentCustomNameUserEntities = paymentCustomNameUserRepo.findByNamePhoneEmailUser("%"+name_+"%","%"+phone_+"%","%"+email_+"%");
            }
        }

        Double totalProceeds_ = 0.;
        Double totalReceivables_ = 0.;

        for(PaymentCustomNameUserEntity i : paymentCustomNameUserEntities){
            if(i.getStatus_().equals("complete")){
                totalProceeds_+=i.getTotal_();
            }else{
                totalReceivables_+=i.getTotal_();
            }
        }

        ApiRespone<RMPRespone> apiRespone = new ApiRespone<>();
        apiRespone.setApi_desription_("return to search method");
        apiRespone.setApi_respone_("200");
        apiRespone.setApi_result_(RMPRespone.builder()
                        .payment_(paymentCustomNameUserEntities)
                        .user_(userEntities_)
                        .service_(serviceEntities_)
                        .paymentMethod_(paymentMethodEntities)
                        .apartmentEntiries_(apartmentEntiries_)
                        .totalProceeds_(totalProceeds_)
                        .totalReceivables_(totalReceivables_)
                        .build());

        return apiRespone;

    }


    public ApiRespone<UpdateDeleteCreateRespone> updateRMPUser(UserUpdateRequest userUpdateRequest){


        /*update the user table
         * update and check err user table
         * */


        try {
            userRepo.updateUser(userUpdateRequest.getName_(),
                    userUpdateRequest.getGender_(),
                    userUpdateRequest.getEmail_(),
                    userUpdateRequest.getStart_day_(),
                    userUpdateRequest.getEnd_day_(),
                    userUpdateRequest.getPhone_(),
                    userUpdateRequest.getTotal_payment_(),
                    userUpdateRequest.getDebt_(),
                    userUpdateRequest.getStatus_(),
                    userUpdateRequest.getPassword_(),
                    userUpdateRequest.getSsn_(),
                    userUpdateRequest.getAddress_(),
                    userUpdateRequest.getId_());

            ApiRespone<UpdateDeleteCreateRespone> apiRespone = ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("Update payment user"+userUpdateRequest.getId_())
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_("update submit a user data")
                            .check_(true)
                            .build())
                    .build();
            return apiRespone;
        } catch (Exception e) {
            ApiRespone<UpdateDeleteCreateRespone> apiRespone = ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("Update payment user"+userUpdateRequest.getId_())
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_(e.toString())
                            .check_(false)
                            .build())
                    .build();
            return apiRespone;
        }



    }


    public ApiRespone<UpdateDeleteCreateRespone> upDateRMPPayment(PaymentUpdateRequest paymentUpdateRequest){


        /*Update the payment table
         * update and check err user table
         * */


        try {
            paymentRepo.updatePayment(paymentUpdateRequest.getIdPaymentMethod_(),
                    paymentUpdateRequest.getIdService_(),
                    paymentUpdateRequest.getPaymentDateline_(),
                    paymentUpdateRequest.getStatus_(),
                    paymentUpdateRequest.getTotal_(),
                    paymentUpdateRequest.getId_());
            System.out.println(paymentUpdateRequest);

            ApiRespone<UpdateDeleteCreateRespone> apiRespone = ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("Update payment request"+paymentUpdateRequest.getId_())
                    .api_respone_("200")
                    .api_result_(UpdateDeleteCreateRespone.builder()
                            .desription_("update submit a user data")
                            .check_(true)
                            .build())
                    .build();
            return apiRespone;
        } catch (Exception e) {
            ApiRespone<UpdateDeleteCreateRespone> apiRespone = ApiRespone.<UpdateDeleteCreateRespone>builder()
                    .api_desription_("Update payment request err"+paymentUpdateRequest.getId_())
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


//    public ApiRespone<UpdateDeleteCreateRespone> createPayment(PaymentEntity paymentEntityRequest_){
//
//
//        /*create data user infomation
//        *   create 1 row data user in tabel user_
//        *
//        * */
//
//        System.out.println(paymentEntityRequest_);
//
//        return new ApiRespone<>();
//    }


















}
