package com.example.apispring.repository;

import com.example.apispring.dto.FindPetDiagnosisDto;

import java.util.List;

public interface DiagnosisRepositoryCustom {

    List<FindPetDiagnosisDto> searchDiagnosis(Long petId);
}
