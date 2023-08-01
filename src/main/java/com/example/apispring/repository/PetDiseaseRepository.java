package com.example.apispring.repository;

import com.example.apispring.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetDiseaseRepository extends JpaRepository<Disease, Long> {
    Optional<Disease> findByName(String name);
}
