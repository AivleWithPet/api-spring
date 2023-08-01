package com.example.apispring.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ModelRequestDto {

    private Long petId;
    private String result;
    private MultipartFile imageFile;
}
