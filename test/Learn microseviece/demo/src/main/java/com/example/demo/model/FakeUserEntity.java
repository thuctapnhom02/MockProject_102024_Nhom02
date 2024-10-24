package com.example.demo.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeUserEntity {
    String id_;
    String phone_;
    String password_;
    String name_;
    String age_;
}
