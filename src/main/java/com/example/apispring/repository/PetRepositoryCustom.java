package com.example.apispring.repository;

import com.example.apispring.dto.FindPetDto;

import java.util.List;

public interface PetRepositoryCustom{
    List<FindPetDto> searchMyPets(Long memberId);
}
