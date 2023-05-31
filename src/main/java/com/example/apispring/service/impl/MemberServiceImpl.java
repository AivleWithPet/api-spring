package com.example.apispring.service.impl;

import com.example.apispring.data.dao.MemberDao;
import com.example.apispring.data.dto.MemberDto;
import com.example.apispring.data.entity.MemberEntity;
import com.example.apispring.data.handler.MemberDataHandler;
import com.example.apispring.domain.Member;
import com.example.apispring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    MemberDataHandler memberDataHandler;

    @Autowired
    public MemberServiceImpl(MemberDataHandler memberDataHandler) {
        this.memberDataHandler = memberDataHandler;
    }

    @Override
    public MemberDto saveMember(String memberId, String name, String password) {
        MemberEntity memberEntity = memberDataHandler.saveMemberEntity(memberId, name, password);
        MemberDto memberDto = new MemberDto(memberEntity.getMemberId(), memberEntity.getName(), memberEntity.getPassword());
        return memberDto;
    }

    @Override
    public MemberDto getMember(String memberId) {
        MemberEntity memberEntity = memberDataHandler.getMemberEntity(memberId);
        MemberDto memberDto = new MemberDto(memberEntity.getMemberId(), memberEntity.getName(), memberEntity.getPassword());
        return memberDto;
    }

    @Override
    public List<MemberDto> findAll() {
        List<MemberEntity> memberEntities = memberDataHandler.getMemberEntities();
        List<MemberDto> collect = memberEntities.stream().map(memberEntity -> new MemberDto(memberEntity.getMemberId(), memberEntity.getName(), memberEntity.getPassword()))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public void updateMemberInfo(String memberId, String updatedName, String updatedPassword) {
        MemberEntity memberEntity = memberDataHandler.updateMemberEntity(memberId, updatedName, updatedPassword);

    }

    @Override
    public void deleteMember(String memberId) {
        memberDataHandler.deleteMember(memberId);
    }


}
