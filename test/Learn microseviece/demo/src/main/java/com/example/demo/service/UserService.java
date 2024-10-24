package com.example.demo.service;


import com.example.demo.model.FakeUserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Slf4j
public class UserService {

    @Autowired
    HttpClientUserClient httpClientUserClient;

    public String  createUser(FakeUserEntity fakeUserEntityRequest_){
        System.out.println(fakeUserEntityRequest_);

        ClientUserEntity clientUserEntity = ClientUserEntity.builder()
                .id_("1")
                .name_(fakeUserEntityRequest_.getName_())
                .age_(fakeUserEntityRequest_.getAge_())
                .build();
        System.out.println(clientUserEntity);

        httpClientUserClient.createUser(clientUserEntity);

        return "create phone and pass ok";


    }
}
