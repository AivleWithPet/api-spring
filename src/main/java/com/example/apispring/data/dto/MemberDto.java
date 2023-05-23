package com.example.apispring.data.dto;

import com.example.apispring.data.entity.MemberEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class MemberDto {
    private String memberId;
    private String name;
    private String password;

    public MemberEntity toEntity(){
        return MemberEntity.builder().memberId(memberId)
                .name(name)
                .password(password).build();
    }


}
