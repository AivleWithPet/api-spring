package com.example.apispring.data.handler;

import com.example.apispring.data.entity.MemberEntity;

import java.util.List;

public interface MemberDataHandler {

    MemberEntity saveMemberEntity(String memberId, String name, String password);

    MemberEntity getMemberEntity(String memberId);

    List<MemberEntity> getMemberEntities();

    MemberEntity updateMemberEntity(String memberId, String updatedName, String updatedPassword);
    void deleteMember(String memberId);
}
