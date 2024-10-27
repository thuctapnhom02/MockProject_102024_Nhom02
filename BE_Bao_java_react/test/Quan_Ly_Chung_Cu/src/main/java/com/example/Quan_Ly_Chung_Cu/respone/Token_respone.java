package com.example.Quan_Ly_Chung_Cu.respone;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Token_respone {
    boolean value_;
    String token_;
}
