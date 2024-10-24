package com.example.demo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @RequestMapping("/")
    private String index(){
        return "home page";
    }
}
