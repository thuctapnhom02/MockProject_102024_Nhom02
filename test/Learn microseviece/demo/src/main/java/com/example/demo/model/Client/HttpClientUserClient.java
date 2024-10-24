package com.example.demo.model.Client;


import com.example.demo.model.FakeUserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@FeignClient(name = "userClient",url = "http://127.0.0.1:9091/user")
public interface HttpClientUserClient {

    @PostMapping(value = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
     Object createUser(@RequestBody ClientUserEntity clientUserEntity);


}
