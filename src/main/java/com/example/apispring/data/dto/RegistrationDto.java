package com.example.apispring.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {

    private String email;
    private String username;
    private String password;
}