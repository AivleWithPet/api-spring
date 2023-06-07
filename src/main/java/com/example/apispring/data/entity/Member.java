package com.example.apispring.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Member {
    @Id
    private String memberId;

    @Column
    private String name;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String memberId, String name, String password, Authority authority) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.authority = authority;
    }
}
