package com.example.demo.model.respone.bao;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRespone {
    String token_ ;
    Date time_token_;
    String name_user_;
    String id_user_;
    boolean check_token_;
}
