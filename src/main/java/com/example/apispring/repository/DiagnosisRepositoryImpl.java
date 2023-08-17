package com.example.apispring.repository;

import com.example.apispring.dto.FindPetDiagnosisDto;
import com.example.apispring.entity.Diagnosis;
import com.example.apispring.entity.QDiagnosis;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class DiagnosisRepositoryImpl implements DiagnosisRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public DiagnosisRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<FindPetDiagnosisDto> searchDiagnosis(Long petId) {
        QDiagnosis diagnosis = QDiagnosis.diagnosis;

        BooleanExpression petIdPredicate = diagnosis.pet.id.eq(petId);

        List<Diagnosis> diagnosisList = queryFactory.selectFrom(diagnosis).where(petIdPredicate).fetch();
        List<FindPetDiagnosisDto> petDiagnosisDtos = diagnosisList
                .stream()
                .map(FindPetDiagnosisDto::of)
                .collect(Collectors.toList());

        return petDiagnosisDtos;
    }
}
