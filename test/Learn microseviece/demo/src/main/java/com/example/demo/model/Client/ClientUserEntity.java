package com.example.demo.model.Client;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientUserEntity {
    String id_;
    String name_;
    String age_;
}
