package com.example.demo.model;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "test",url = "http://127.0.0.1:9091/user")
public interface TestClient {
    @RequestMapping("/")
    Object test_();
}
