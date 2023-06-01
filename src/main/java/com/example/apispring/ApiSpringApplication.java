package com.example.apispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication()
public class ApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSpringApplication.class, args);
    }

}
