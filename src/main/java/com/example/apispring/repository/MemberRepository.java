package com.example.apispring.repository;

import com.example.apispring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {
    private static final Map<String, Member> store = new HashMap<>();
//test1
    //test2
    //test3
    public Member save(Member member) {
        store.put(member.getUserid(), member);
        return member;
    }
    public Member findByUserId(String userid) {
        return store.get(userid);
    }

    public void updateMemberInfo(String userid, Member member) {
        Member memberForUpdate = store.get(userid);
        memberForUpdate.setName(member.getName());
        memberForUpdate.setPassword(member.getPassword());
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
