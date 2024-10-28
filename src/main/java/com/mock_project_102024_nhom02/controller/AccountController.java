package com.mock_project_102024_nhom02.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mock_project_102024_nhom02.constants.StringConstant;
import com.mock_project_102024_nhom02.dto.response.PagingResponse;
import com.mock_project_102024_nhom02.dto.response.StaffResponse;
import com.mock_project_102024_nhom02.dto.response.UserResponse;
import com.mock_project_102024_nhom02.service.StaffService;
import com.mock_project_102024_nhom02.service.UserService;

@RestController
@RequestMapping("${api.prefix}"+"/accounts")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {

    StaffService staffService;
    UserService userService;

    @GetMapping
    public ResponseEntity<PagingResponse> getAllStaff(
            @RequestParam(name = "search-value", required = false) String searchValue,
            @RequestParam(name = "account-type", defaultValue = StringConstant.ACCOUNT_TYPE_STAFF, required = false) String accountType,
            @RequestParam(name = "status", defaultValue = StringConstant.ACTIVATE_STATUS, required = false) String status,
            @RequestParam(name = "current-page", defaultValue = "1", required = false) int currentPage,
            @RequestParam(name = "page-size", defaultValue = "9", required = false) int pageSize
            ){
        PagingResponse<?> response = null;
        if(accountType.equals("staff")){
            Page<StaffResponse> staffList = staffService.getAllStaff(searchValue, status, currentPage, pageSize);
            response = response.builder()
                    .code(200)
                    .searchValue(searchValue)
                    .accountType(accountType)
                    .status(status)
                    .currentPage(currentPage)
                    .pageSize(pageSize)
                    .result(staffList.toList())
                    .totalItem(staffList.getTotalElements())
                    .totalPage(staffList.getTotalPages())
                    .build();
        } else if (accountType.equals("user")) {
            Page<UserResponse> userList = userService.getAllUsers(searchValue, status, currentPage, pageSize);
            response = response.builder()
                    .code(200)
                    .searchValue(searchValue)
                    .accountType(accountType)
                    .status(status)
                    .currentPage(currentPage)
                    .pageSize(pageSize)
                    .result(userList.toList())
                    .totalItem(userList.getTotalElements())
                    .totalPage(userList.getTotalPages())
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(response);
    }

}
