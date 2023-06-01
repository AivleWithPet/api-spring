package com.example.apispring.data.dto;

import com.example.apispring.data.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
    private String memberId;
    private String name;

    public static MemberResponseDto of(MemberEntity member) {
        return MemberResponseDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .build();
    }
}