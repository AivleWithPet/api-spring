package com.example.apispring.service;

import com.example.apispring.dto.LoginInfoDto;
import com.example.apispring.dto.MemberRequestDto;
import com.example.apispring.dto.MemberResponseDto;
import com.example.apispring.dto.TokenDto;
import com.example.apispring.entity.Member;
import com.example.apispring.jwt.TokenProvider;
import com.example.apispring.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public MemberResponseDto signup(MemberRequestDto requestDto) {
        if (memberRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        Member member = requestDto.toMember(passwordEncoder);
        return MemberResponseDto.of(memberRepository.save(member));
    }

    public LoginInfoDto login(MemberRequestDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
        Member member = memberRepository.findByEmail(requestDto.getEmail()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
        String name = member.getName();
        Long memberId = member.getId();
        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);
        return new LoginInfoDto(tokenDto.getAccessToken(), tokenDto.getRefreshToken(), name, memberId);
    }

}