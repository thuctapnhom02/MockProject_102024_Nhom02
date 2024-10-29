package com.mock_project_102024_nhom02.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.mock_project_102024_nhom02.dto.response.ApiResponse;
import com.mock_project_102024_nhom02.dto.request.UserRequest;
import com.mock_project_102024_nhom02.dto.response.UserResponse;
import com.mock_project_102024_nhom02.service.UserService;

@RestController
@RequestMapping("${api.prefix}"+"/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    // Lấy danh sách tất cả người dùng
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {
        ApiResponse<List<UserResponse>> apiResponse = ApiResponse.<List<UserResponse>>builder()
                .response(HttpStatus.OK.value())
                .message("This is the data of users")
                .result(userService.getAllUsers())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    // Lấy thông tin chi tiết của một người dùng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable("id") String id) {
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse>builder()
                .response(HttpStatus.OK.value())
                .message("This is the data of user.")
                .result(userService.getUserById(id))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    // Thêm một người dùng mới
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> addUser(@RequestBody UserRequest userRequest) {
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse>builder()
                .response(HttpStatus.CREATED.value())
                .message("User created successfully")
                .result(userService.addUser(userRequest))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    // Cập nhật thông tin của một người dùng
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@RequestBody UserRequest userRequest, @PathVariable("id") String id) {
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse>builder()
                .response(HttpStatus.OK.value())
                .message("User updated successfully")
                .result(userService.updateUser(userRequest, id))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    // Xóa một người dùng
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable("id") String id) {
        userService.deleteUserById(id);
        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                .response(HttpStatus.NO_CONTENT.value())
                .message("User deleted successfully")
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
    }
}
