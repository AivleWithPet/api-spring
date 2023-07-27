package com.example.apispring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginInfoDto {
    private String accessToken;
    private String refreshToken;
    private String name;
    private Long memberId;
}
