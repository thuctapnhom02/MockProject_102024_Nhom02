package com.example.demo.controller.bao;


import com.example.demo.api_setting.ApiRespone;
import com.example.demo.model.entity.bao.PaymentEntity;
import com.example.demo.model.entity.bao.StaffEntity;
import com.example.demo.model.entity.bao.UserEntity;
import com.example.demo.model.request.bao.ComplaintSearchRequest;
import com.example.demo.model.request.bao.SMPSearchRequest;
import com.example.demo.model.request.bao.SearchStaffRequest;
import com.example.demo.model.request.bao.UpdateComplaintRequest;
import com.example.demo.model.respone.bao.ComplaintRespone;
import com.example.demo.model.respone.bao.StaffRespone;
import com.example.demo.model.respone.bao.UpdateDeleteCreateRespone;
import com.example.demo.model.respone.bao.RMPRespone;
import com.example.demo.model.serviece.bao.ComplaintService;
import com.example.demo.model.serviece.bao.RMPServiece;
import com.example.demo.model.serviece.bao.StaffService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("${api.prefix}" + "/resident-payments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminController {

    @Autowired
    RMPServiece rmpServiece;
    @Autowired
    ComplaintService complaintService;
    @Autowired
    StaffService staffService;

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/search")
    ApiRespone<RMPRespone> ResidentManagementAndPaymentsService(@RequestParam(name = "name", required = false) String name_,
                                                                @RequestParam(name = "phone", required = false) String phone_,
                                                                @RequestParam(name = "email", required = false) String email_,
                                                                @RequestParam(name = "apartment_id", required = false) String idApartment_) {
        ApiRespone<RMPRespone> apiRespone = null;

        if (Objects.isNull(name_) && Objects.isNull(phone_) && Objects.isNull(email_) && Objects.isNull(idApartment_)) {
            return rmpServiece.searchResidentManagementAndPayments(null, null, null, null);
        }
        return rmpServiece.searchResidentManagementAndPayments(name_, phone_, email_, idApartment_);
    }


    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/update-payment-user")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsUpdateUser(@RequestBody UserEntity userEntityRequest_) {
        ApiRespone<UpdateDeleteCreateRespone> apiResponse = rmpServiece.updateRMPUser(userEntityRequest_);

        return apiResponse;
    }


    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/update-payment")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsUpdatePayment(@RequestBody PaymentEntity paymentEntity) {
        ApiRespone<UpdateDeleteCreateRespone> apiResponse = rmpServiece.upDateRMPPayment(paymentEntity);

        return apiResponse;
    }


    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/delete-user/{id}")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsDeleteUser(@PathVariable("id") String userId_) {
        ApiRespone<UpdateDeleteCreateRespone> apiResponse = rmpServiece.deleteUser(userId_);

        return apiResponse;
    }


    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/delete-payment/{id}")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsDeletePayment(@PathVariable("id")  String paymentId_) {
        ApiRespone<UpdateDeleteCreateRespone> apiResponse = rmpServiece.deletePayment(paymentId_);

        return apiResponse;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/create-user")
    ApiRespone<UpdateDeleteCreateRespone> ResidentManagementAndPaymentsCreateUser(@RequestBody UserEntity userEntityRequest_) {

        ApiRespone<UpdateDeleteCreateRespone> apiResponse = rmpServiece.createUser(userEntityRequest_);

        return apiResponse;
    }


    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/complaints")
    ApiRespone<ComplaintRespone> getAllComplaint(@RequestParam(name = "nameUser_",required = false) String name_,
                                                 @RequestParam(name = "status_",required = false) String status_) {

        ComplaintSearchRequest complaintSearchRequest = new ComplaintSearchRequest(name_,status_);
        ApiRespone<ComplaintRespone> apiResponse = complaintService.getAllComplaint(complaintSearchRequest);

        return apiResponse;
    }


    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/update-complaint")
    ApiRespone<UpdateDeleteCreateRespone> updateComplaint(@RequestBody UpdateComplaintRequest updateComplaintRequest) {
        ApiRespone<UpdateDeleteCreateRespone> apiResponse = complaintService.updateComplaint(updateComplaintRequest);

        return apiResponse;
    }


    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/complaint-detail/{id}")
    ApiRespone<ComplaintRespone> getComplaintById(@PathVariable("id") String idComplaint_) {
        ApiRespone<ComplaintRespone> apiResponse = complaintService.getDtailComplaint(idComplaint_);

        return apiResponse;
    }


    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/staff/search")
    ApiRespone<StaffRespone> test_1(@RequestParam(name = "name_", required = false) String name_,
                                    @RequestParam(name = "status_", required = false) String status_) {
        ApiRespone<StaffRespone> apiResponse = staffService.search(SearchStaffRequest.builder().name_(name_).status_(status_).build());

        return apiResponse;
    }


    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/staff/update")
    ApiRespone<UpdateDeleteCreateRespone> updateStaff(@RequestBody StaffEntity staffEntityRequest_) {
        ApiRespone<UpdateDeleteCreateRespone> updateDeleteCreateResponeApiRespone = staffService.updateStaff(staffEntityRequest_);

        return updateDeleteCreateResponeApiRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/staff/create")
    ApiRespone<UpdateDeleteCreateRespone> createStaff(@RequestBody StaffEntity staffEntityRequest_) {
        ApiRespone<UpdateDeleteCreateRespone> updateDeleteCreateRespone = staffService.createStaff(staffEntityRequest_);

        return updateDeleteCreateRespone;
    }


    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/staff/delete/{id}")
    ApiRespone<UpdateDeleteCreateRespone> createStaff(@PathVariable("id") String idStaff_) {
        ApiRespone<UpdateDeleteCreateRespone> updateDeleteCreateRespone = staffService.deleteStaff(idStaff_);

        return updateDeleteCreateRespone;
    }



}



