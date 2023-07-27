package com.example.apispring.repository;

import com.example.apispring.dto.PetResponseDto;

import java.util.List;

public interface PetRepositoryCustom{
    List<PetResponseDto> searchMyPets(Long memberId);
}
