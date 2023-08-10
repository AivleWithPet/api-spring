package com.example.apispring.dto;

import com.example.apispring.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class PetRequestDto {
    private MultipartFile photo;
    private String species;
    private int birthYear;
    private String petName;
    private String info;

}
