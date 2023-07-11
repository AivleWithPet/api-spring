package com.example.apispring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    private String grantType;
    private String accessToken;
    private Long tokenExpiresIn;

    private Long refreshTokenExpiresIn;
    private String refreshToken;//refresh토큰
    private String name;//회원 이름
}
