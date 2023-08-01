package com.example.apispring.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ResultResponseDto {
    private String inform;
    private String supplements;
    private String diseaseName;

}
