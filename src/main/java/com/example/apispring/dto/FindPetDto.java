package com.example.apispring.dto;

import com.example.apispring.entity.Pet;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class FindPetDto {
    private Long petId;
    private String species;
    private Integer birthYear;
    private String petName;
    private String info;
    private String photoPath;
    public static FindPetDto of(Pet pet) {
        return FindPetDto.builder()
                .petId(pet.getId())
                .species(pet.getSpecies())
                .birthYear(pet.getBirthYear())
                .petName(pet.getPetName())
                .info(pet.getInfo())
                .photoPath(pet.getPhotoPath())
                .build();
    }
}
