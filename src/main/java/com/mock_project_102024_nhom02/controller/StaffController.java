package com.mock_project_102024_nhom02.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.mock_project_102024_nhom02.dto.response.ApiResponse;
import com.mock_project_102024_nhom02.dto.response.StaffResponse;
import com.mock_project_102024_nhom02.service.StaffService;
import com.mock_project_102024_nhom02.constants.StringConstant;
import com.mock_project_102024_nhom02.dto.request.StaffRequest;
import com.mock_project_102024_nhom02.dto.response.PagingResponse;

@RestController
@RequestMapping("${api.prefix}"+"/staff")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StaffController {

    StaffService staffService;


    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse<List<StaffResponse>> apiResponse = ApiResponse.<List<StaffResponse>>builder()
                .message("This is the data of income")
                .response(HttpStatus.OK.value())
                .result(staffService.getAllStaff())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PagingResponse> getAllStaff(
            @RequestParam(name = "search-value", required = false) String searchValue,
            @RequestParam(name = "account-type", defaultValue = StringConstant.ACCOUNT_TYPE_STAFF, required = false) String accountType,
            @RequestParam(name = "status", defaultValue = StringConstant.ACTIVATE_STATUS, required = false) String status,
            @RequestParam(name = "current-page", defaultValue = "1", required = false) int currentPage,
            @RequestParam(name = "page-size", defaultValue = "9", required = false) int pageSize
    ){
        Page<StaffResponse> staffList = staffService.getAllStaffWithCondition(searchValue, status, accountType, currentPage, pageSize);
        PagingResponse<?> response = PagingResponse.builder()
                .code(200)
                .currentPage(currentPage)
                .pageSize(pageSize)
                .result(staffList.toList())
                .totalItem(staffList.getTotalElements())
                .totalPage(staffList.getTotalPages())
                .build();
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getStaffById(@PathVariable("id") String id) {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(ApiResponse.<StaffResponse>builder()
                        .description("This is the data of the staff.")
                        .result(staffService.getStaffById(id))
                        .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addStaff(@RequestBody StaffRequest staffRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(ApiResponse.<StaffResponse>builder()
                        .description("This is the data of the staff.")
                        .result(staffService.addStaff(staffRequest))
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateStaff( @PathVariable("id") String id,
                                                   @RequestBody StaffRequest staffRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(ApiResponse.<StaffResponse>builder()
                        .description("This is the data of the staff.")
                        .result(staffService.updateStaff(staffRequest,id))
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> addStaff(@PathVariable("id") String id) {
        staffService.deleteStaff(id);
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(ApiResponse.<List<StaffResponse>>builder()
                        .message("Delete success")
                        .build());
    }

}
