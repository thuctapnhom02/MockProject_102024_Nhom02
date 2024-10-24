package com.example.demo.controller;


import com.example.demo.api_setting.ApiRespone;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.request.PaymentUpdateRequest;
import com.example.demo.model.request.SMPSearchRequest;
import com.example.demo.model.respone.UpdateDeleteCreateRespone;
import com.example.demo.model.request.UserUpdateRequest;
import com.example.demo.model.respone.RMPRespone;
import com.example.demo.model.serviece.RMPServiece;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminController {

    @Autowired
    RMPServiece rmpServiece;

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/ResidentManagementAndPayments")
    ApiRespone<RMPRespone> ResidentManagementAndPaymentsServiece(@RequestBody SMPSearchRequest SMPSearchRequest){
        ApiRespone<RMPRespone> apiRespone = rmpServiece.searchResidentManagementAndPayments(SMPSearchRequest.getName_(),
                SMPSearchRequest.getPhone_(),
                SMPSearchRequest.getEmail_(),
                SMPSearchRequest.getIdApartment_());

        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @RequestMapping("/ResidentManagementAndPayments")
    ApiRespone<RMPRespone> ResidentManagementAndPaymentsGet(){
        ApiRespone<RMPRespone> apiRespone = rmpServiece.searchResidentManagementAndPayments(null, null, null,null);

        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/ResidentManagementAndPaymentsUpdateUser")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsUpdateUser(@RequestBody  UserUpdateRequest userUpdateRequest){
        System.out.println(userUpdateRequest);
        ApiRespone<UpdateDeleteCreateRespone> apiRespone = rmpServiece.updateRMPUser(userUpdateRequest);

        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/ResidentManagementAndPaymentsUpdatePayment")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsUpdatePayment(@RequestBody PaymentUpdateRequest paymentUpdateRequest){
        ApiRespone<UpdateDeleteCreateRespone> apiRespone = rmpServiece.upDateRMPPayment(paymentUpdateRequest);

        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/ResidentManagementAndPaymentsDeleteUser")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsDeleteUser(@RequestBody String userId_){
        ApiRespone<UpdateDeleteCreateRespone> apiRespone = rmpServiece.deleteUser(userId_);

        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/ResidentManagementAndPaymentsDeletePayment")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsDeletePayment(@RequestBody String paymentId_){
        ApiRespone<UpdateDeleteCreateRespone> apiRespone = rmpServiece.deletePayment(paymentId_);

        return apiRespone;
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/ResidentManagementAndPaymentsCreateUser")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsCreateUser(@RequestBody UserEntity userEntityRequest_){

        ApiRespone<UpdateDeleteCreateRespone> apiRespone = rmpServiece.createUser(userEntityRequest_);

        return apiRespone;
    }




















}
