package com.example.apispring.repository;

import com.example.apispring.data.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, String> {
}