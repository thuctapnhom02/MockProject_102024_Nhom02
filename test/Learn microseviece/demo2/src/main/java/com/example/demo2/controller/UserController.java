package com.example.demo2.controller;


import com.example.demo2.model.UserEntity;
import com.example.demo2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {


    UserService userService;


    @PostMapping("/user")
    private String createUser(@RequestBody UserEntity fakeUserEntityReauest_){
        return userService.createUser(fakeUserEntityReauest_);
    }

}
