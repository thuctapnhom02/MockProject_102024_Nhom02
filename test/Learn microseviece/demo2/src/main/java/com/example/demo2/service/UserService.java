package com.example.demo2.service;


import com.example.demo2.model.UserEntity;
import lombok.*;
import org.springframework.stereotype.Service;


@Data
@RequiredArgsConstructor
@Builder
@Service
public class UserService {
    public String  createUser(UserEntity fakeUserEntityRequest_){
        System.out.println("create vcl");
        return "create phone and pass ok";
    }
}
