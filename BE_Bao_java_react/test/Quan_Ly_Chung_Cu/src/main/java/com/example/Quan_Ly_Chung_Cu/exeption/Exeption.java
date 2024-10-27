package com.example.Quan_Ly_Chung_Cu.exeption;

import com.example.Quan_Ly_Chung_Cu.Api.Api_exeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exeption {



    @ExceptionHandler(value = Exeption_custom.class)
    ResponseEntity<Api_exeption> test(Exeption_custom err){

        Api_exeption api = Api_exeption.builder()
                .ping_err(err.getErr_code_().getErr_code())
                .mess_err(err.getErr_code_().getMess())
                .build();

        return ResponseEntity.badRequest().body(api);
    }

}
