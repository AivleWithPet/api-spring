package com.example.apispring.repository;

import com.example.apispring.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberId(String memberId);
    boolean existsByMemberId(String memberId);
}