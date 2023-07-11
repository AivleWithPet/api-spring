package com.example.apispring.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String email;
    @Column
    private String name;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

//    @Builder
//    public Member(String memberId, String name, String password, Authority authority) {
//        this.memberId = memberId;
//        this.name = name;
//        this.password = password;
//        this.authority = authority;
//    }
}
