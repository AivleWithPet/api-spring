package com.example.apispring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {

    private String memberId;
    private String username;
    private String password;
}