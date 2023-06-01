package com.example.apispring.service;

import com.example.apispring.data.dto.MemberRequestDto;
import com.example.apispring.data.dto.MemberResponseDto;
import com.example.apispring.data.dto.TokenDto;
import com.example.apispring.data.entity.MemberEntity;
import com.example.apispring.jwt.TokenProvider;
import com.example.apispring.repository.MemberEntityRepository;
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
    private final MemberEntityRepository memberEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public MemberResponseDto signup(MemberRequestDto requestDto) {
        if (memberEntityRepository.existsByMemberId(requestDto.getMemberId())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        MemberEntity member = requestDto.toMember(passwordEncoder);
        return MemberResponseDto.of(memberEntityRepository.save(member));
    }

    public TokenDto login(MemberRequestDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateTokenDto(authentication);
    }

}