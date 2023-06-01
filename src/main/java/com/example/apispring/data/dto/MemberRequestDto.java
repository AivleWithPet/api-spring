package com.example.apispring.data.dto;

import com.example.apispring.data.entity.Authority;
import com.example.apispring.data.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequestDto {
    private String memberId;
    private String password;
    private String name;

    public MemberEntity toMember(PasswordEncoder passwordEncoder) {
        return MemberEntity.builder()
                .memberId(memberId)
                .password(passwordEncoder.encode(password))
                .name(name)
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(memberId, password);
    }
}