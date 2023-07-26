package com.example.apispring.repository;

import com.example.apispring.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDiseaseRepository extends JpaRepository<Disease, Long> {
}
