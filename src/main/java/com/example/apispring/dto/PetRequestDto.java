package com.example.apispring.dto;

import com.example.apispring.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PetRequestDto {
    private String species;
    private int birthYear;
    private String petName;
    private String info;

}
