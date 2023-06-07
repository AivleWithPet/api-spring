//package com.example.apispring.data.dao.impl;
//
//import com.example.apispring.data.dao.MemberDao;
//import com.example.apispring.repository.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MemberDaoImpl implements MemberDao {
//    MemberRepository memberRepository;
//
//    @Autowired
//    public MemberDaoImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Override
//    public MemberEntity saveMember(MemberEntity memberEntity) {
//        memberRepository.save(memberEntity);
//        return memberEntity;
//    }
//
//    @Override
//    public MemberEntity getMember(String memberId) {
//        MemberEntity memberentity = memberRepository.getReferenceById(memberId);
//        return memberentity;
//    }
//
//    @Override
//    public List<MemberEntity> getMembers() {
//        List<MemberEntity> members = memberRepository.findAll();
//        return members;
//    }
//
//    @Override
//    public void deleteMember(String memberId) {
//        memberRepository.deleteById(memberId);
//    }
//
//}
