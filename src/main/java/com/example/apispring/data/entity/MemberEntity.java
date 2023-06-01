package com.example.apispring.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
public class MemberEntity {

    @Id
    private String memberId;
    private String name;
    private String password;


    @Enumerated(EnumType.STRING)
    private Authority authority;

}
