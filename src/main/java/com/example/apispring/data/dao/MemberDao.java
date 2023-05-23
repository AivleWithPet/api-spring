package com.example.apispring.data.dao;

import com.example.apispring.data.entity.MemberEntity;

import java.util.List;

public interface MemberDao {
    MemberEntity saveMember(MemberEntity memberEntity);
    MemberEntity getMember(String memberId);

    List<MemberEntity> getMembers();
}
