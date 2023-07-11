package com.example.apispring.repository;

import com.example.apispring.data.entity.PetDisease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDiseaseRepository extends JpaRepository<PetDisease, Long> {
}
