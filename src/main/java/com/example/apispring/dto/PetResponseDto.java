package com.example.apispring.dto;

import com.example.apispring.entity.Pet;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class PetResponseDto {
    private Long petId;
    private String species;
    private Integer birthYear;
    private String petName;
    private String info;

    public static PetResponseDto of(Pet pet) {
        return PetResponseDto.builder()
                .petId(pet.getId())
                .species(pet.getSpecies())
                .birthYear(pet.getBirthYear())
                .petName(pet.getPetName())
                .info(pet.getInfo())
                .build();
    }
}
