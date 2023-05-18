package com.example.apispring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
//test
//test2
public class Member {
    private String name;
    private String userid;
    private String password;

    public Member() {
    }
    public Member(String name, String userid, String password) {
        this.name = name;
        this.userid = userid;
        this.password = password;
    }
}
