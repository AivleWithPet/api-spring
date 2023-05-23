package com.example.apispring.service;

import com.example.apispring.data.dto.MemberDto;
import com.example.apispring.domain.Member;

import java.util.ArrayList;
import java.util.List;

public interface MemberService {
    MemberDto saveMember(String memberId, String memberName, String password);
    MemberDto getMember(String memberId);
    List<MemberDto> findAll();
//    void updateMemberInfo(String memberId, String updatedName, String updatedPassword);
}
