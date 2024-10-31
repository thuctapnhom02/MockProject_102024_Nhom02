package com.mock_project_102024_nhom02.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mock_project_102024_nhom02.dto.response.ApiResponse;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(errorCode.getMessage());
        apiResponse.setResponse(errorCode.getCode());
        return ResponseEntity.status(errorCode.getStatus()).body(apiResponse);
    }


}
