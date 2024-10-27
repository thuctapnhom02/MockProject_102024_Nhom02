package com.example.Quan_Ly_Chung_Cu.Api;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Api_exeption {
    int ping_err ;
    String mess_err ;
}
