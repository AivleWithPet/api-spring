package com.example.apispring.repository;

import com.example.apispring.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long>, DiagnosisRepositoryCustom {
}
