package com.example.apispring.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResultResponseDto {
    private String inform;
    private String supplements;
    private String diseaseName;
    private Double percentage;
    private LocalDateTime createdAt;
    private String imageBase64;
}
