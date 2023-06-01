package com.example.apispring.repository;

import com.example.apispring.data.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findByMemberId(String memberId);
    boolean existsByMemberId(String memberId);
}