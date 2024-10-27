package com.example.demo.service;


import com.example.demo.model.Client.ClientUserEntity;
import com.example.demo.model.Client.HttpClientUserClient;
import com.example.demo.model.FakeUserEntity;
import com.example.demo.model.TestClient;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {

    @Autowired
    HttpClientUserClient httpClientUserClient;
    @Autowired
    TestClient testClient;

    public String  createUser(FakeUserEntity fakeUserEntityRequest_){
        System.out.println(fakeUserEntityRequest_);

        ClientUserEntity clientUserEntity = ClientUserEntity.builder()
                .id_("1")
                .name_(fakeUserEntityRequest_.getName_())
                .age_(fakeUserEntityRequest_.getAge_())
                .build();
        System.out.println(clientUserEntity);
        try {
//            httpClientUserClient.createUser(clientUserEntity);
            httpClientUserClient.createUser(clientUserEntity);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "create phone and pass ok";


    }
}
