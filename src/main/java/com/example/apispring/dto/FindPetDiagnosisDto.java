package com.example.apispring.dto;

import com.example.apispring.entity.Diagnosis;
import com.example.apispring.entity.Disease;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FindPetDiagnosisDto {
    private String photoPath;
    private Double percentage;
    private LocalDateTime createdAt;
    private Disease disease;

    public static FindPetDiagnosisDto of(Diagnosis diagnosis){
        return FindPetDiagnosisDto.builder()
                .photoPath(diagnosis.getPhotoPath())
                .percentage(diagnosis.getPercentage())
                .createdAt(diagnosis.getCreated_at())
                .disease(diagnosis.getDisease())
                .build();
    }
}
