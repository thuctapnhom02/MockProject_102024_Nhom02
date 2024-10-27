package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.api_setting.ApiRespone;
import com.example.demo.model.respone.ExceptionErrRespont;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

// @FieldDefaults(level = AccessLevel.PRIVATE)
@ControllerAdvice
public class ExceptionApp {

    @ExceptionHandler(value = ExceptionCustom.class)
    ResponseEntity<ApiRespone<String>> err_respone(ExceptionCustom exeptioncustom){

        return ResponseEntity.badRequest().body(ApiRespone.<String>builder()
                        .api_respone_(exeptioncustom.getErrCode_())
                        .api_desription_(exeptioncustom.getDesription_())
                        .api_result_("request error!!!!!!!!")
                .build());
    }
    

}
