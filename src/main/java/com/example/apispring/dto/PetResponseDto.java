package com.example.apispring.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PetResponseDto {
    private Long petId;
    private String petName;
    private String species;
    private Integer birthYear;
    private String info;
    private String photoData;
}
