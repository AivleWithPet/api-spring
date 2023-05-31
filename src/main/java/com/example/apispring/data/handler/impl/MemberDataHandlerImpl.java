package com.example.apispring.data.handler.impl;

import com.example.apispring.data.dao.MemberDao;
import com.example.apispring.data.entity.MemberEntity;
import com.example.apispring.data.handler.MemberDataHandler;
import com.example.apispring.domain.Member;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MemberDataHandlerImpl implements MemberDataHandler {

    MemberDao memberDao;
    @Autowired
    public MemberDataHandlerImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public MemberEntity saveMemberEntity(String memberId, String name, String password) {
        MemberEntity memberEntity = new MemberEntity(memberId, name, password);

        return memberDao.saveMember(memberEntity);
    }

    @Override
    public MemberEntity getMemberEntity(String memberId) {
        return memberDao.getMember(memberId);
    }

    @Override
    public List<MemberEntity> getMemberEntities() {
        return memberDao.getMembers();
    }

    @Override
    public MemberEntity updateMemberEntity(String memberId, String updatedName, String updatedPassword) {
        MemberEntity member = memberDao.getMember(memberId);
        member.setName(updatedName);
        member.setPassword(updatedPassword);
        return member;
    }

    @Override
    public void deleteMember(String memberId) {
        memberDao.deleteMember(memberId);
    }


}
