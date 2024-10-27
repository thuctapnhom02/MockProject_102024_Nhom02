package com.example.Quan_Ly_Chung_Cu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class QuanLyChungCuApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanLyChungCuApplication.class, args);
	}

}
