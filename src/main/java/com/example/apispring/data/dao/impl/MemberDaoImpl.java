package com.example.apispring.data.dao.impl;

import com.example.apispring.data.dao.MemberDao;
import com.example.apispring.data.entity.MemberEntity;
import com.example.apispring.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberDaoImpl implements MemberDao {
    MemberEntityRepository memberEntityRepository;

    @Autowired
    public MemberDaoImpl(MemberEntityRepository memberEntityRepository) {
        this.memberEntityRepository = memberEntityRepository;
    }

    @Override
    public MemberEntity saveMember(MemberEntity memberEntity) {
        memberEntityRepository.save(memberEntity);
        return memberEntity;
    }

    @Override
    public MemberEntity getMember(String memberId) {
        MemberEntity memberentity = memberEntityRepository.getReferenceById(memberId);
        return memberentity;
    }

    @Override
    public List<MemberEntity> getMembers() {
        List<MemberEntity> members = memberEntityRepository.findAll();
        return members;
    }

}
