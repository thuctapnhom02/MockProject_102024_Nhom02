package com.example.demo.exception;

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
    ApiRespone<ExceptionErrRespont> err_respone(ExceptionCustom exeptioncustom){
        
        ApiRespone<ExceptionErrRespont> api = new ApiRespone<>();

        api.setApi_desription_(exeptioncustom.getDesription_());
        api.setApi_respone_(exeptioncustom.getErr_code_().getErr_code());
        api.setApi_result_(ExceptionErrRespont.builder()
                        .err_code_(exeptioncustom.getErr_code_().getErr_code())
                        .mess_(exeptioncustom.getErr_code_().getMess())
                        .build());
        
        return api;
    }
    

}
