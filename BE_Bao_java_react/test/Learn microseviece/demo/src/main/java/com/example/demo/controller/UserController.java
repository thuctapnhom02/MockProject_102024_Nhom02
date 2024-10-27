package com.example.demo.controller;


import com.example.demo.model.FakeUserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/user")
    private String createUser(@RequestBody FakeUserEntity fakeUserEntityReauest_){
        return userService.createUser(fakeUserEntityReauest_);
    }

}
