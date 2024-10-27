package com.example.demo.controller;


import com.example.demo.api_setting.ApiRespone;
import com.example.demo.model.entity.PaymentEntity;
import com.example.demo.model.entity.StaffEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.entity.custom.ComplaintCustomNameUserEntity;
import com.example.demo.model.request.*;
import com.example.demo.model.respone.ComplaintRespone;
import com.example.demo.model.respone.StaffRespone;
import com.example.demo.model.respone.UpdateDeleteCreateRespone;
import com.example.demo.model.respone.RMPRespone;
import com.example.demo.model.serviece.ComplaintService;
import com.example.demo.model.serviece.RMPServiece;
import com.example.demo.model.serviece.StaffService;
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
    @Autowired
    ComplaintService complaintService;
    @Autowired
    StaffService staffService;

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
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsUpdateUser(@RequestBody  UserEntity userEntityRequest_){
        ApiRespone<UpdateDeleteCreateRespone> apiRespone = rmpServiece.updateRMPUser(userEntityRequest_);

        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/ResidentManagementAndPaymentsUpdatePayment")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsUpdatePayment(@RequestBody PaymentEntity paymentEntity){
        ApiRespone<UpdateDeleteCreateRespone> apiRespone = rmpServiece.upDateRMPPayment(paymentEntity);

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


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/complaint")
    ApiRespone<ComplaintRespone> getAllComplaint(@RequestBody ComplaintSearchRequest complaintSearchRequest){
        ApiRespone<ComplaintRespone> apiRespone = complaintService.getAllComplaint(complaintSearchRequest);

        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/complaintUpdate")
    ApiRespone<UpdateDeleteCreateRespone> updateComplaint(@RequestBody UpdateComplaintRequest updateComplaintRequest){
        ApiRespone<UpdateDeleteCreateRespone> apiRespone = complaintService.updateComplaint(updateComplaintRequest);

        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/complaintDetail")
    ApiRespone<ComplaintRespone> getComplaintById(@RequestBody String idComplaint_){
        ApiRespone<ComplaintRespone> apiRespone = complaintService.getDtailComplaint(idComplaint_);

        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/staff")
    ApiRespone<StaffRespone> test_1(@RequestBody SearchStaffRequest searchStaffRequest){
        System.out.println(searchStaffRequest);
        ApiRespone<StaffRespone> apiRespone = staffService.search(searchStaffRequest);
        return apiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/staff/update")
    ApiRespone<UpdateDeleteCreateRespone> updateStaff(@RequestBody StaffEntity staffEntityRequest_){
        ApiRespone<UpdateDeleteCreateRespone> updateDeleteCreateResponeApiRespone = staffService.updateStaff(staffEntityRequest_);

        return updateDeleteCreateResponeApiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/staff/create")
    ApiRespone<UpdateDeleteCreateRespone> createStaff(@RequestBody StaffEntity staffEntityRequest_){
        ApiRespone<UpdateDeleteCreateRespone> updateDeleteCreateRespone = staffService.createStaff(staffEntityRequest_);

        return updateDeleteCreateRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/staff/delete")
    ApiRespone<UpdateDeleteCreateRespone> createStaff(@RequestBody String idStaff_){
        ApiRespone<UpdateDeleteCreateRespone> updateDeleteCreateRespone = staffService.deleteStaff(idStaff_);

        return updateDeleteCreateRespone;
    }




















}
