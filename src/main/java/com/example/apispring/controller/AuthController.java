package com.example.apispring.controller;

import com.example.apispring.dto.LoginInfoDto;
import com.example.apispring.dto.MemberRequestDto;
import com.example.apispring.dto.MemberResponseDto;
import com.example.apispring.dto.TokenDto;
import com.example.apispring.jwt.TokenProvider;
import com.example.apispring.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials="true")
public class AuthController {
    private final AuthService authService;

    private final TokenProvider tokenProvider;
    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginInfoDto> login(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }

    @PostMapping("/refresh-token") //이거 네이밍 마음에 안듦 바꾸자
    public TokenDto refreshToken(@RequestBody TokenDto tokenDto) {
        String refreshToken = tokenDto.getRefreshToken();
        if (tokenProvider.validateToken(refreshToken)) {
            Authentication authentication = tokenProvider.getAuthentication(refreshToken);

            // 새로운 액세스 토큰 생성
            TokenDto newTokenDto = tokenProvider.generateTokenDto(authentication);
            System.out.println("새로운 액세스 토큰:" + newTokenDto.getRefreshToken());
            // 새로운 토큰 DTO를 클라이언트로 전송합니다.
            return newTokenDto;
        } else {
            throw new RuntimeException("유효하지 않은 리프레시 토큰입니다.");
        }
    }
}
