package com.example.apispring.repository;

import com.example.apispring.dto.FindPetDto;
import com.example.apispring.entity.Pet;
import com.example.apispring.entity.QPet;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class PetRepositoryImpl implements PetRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public PetRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }


    @Override
    public List<FindPetDto> searchMyPets(Long memberId) {
        QPet pet = QPet.pet;

        BooleanExpression memberIdPredicate = pet.member.id.eq(memberId);

        List<Pet> pets = queryFactory.selectFrom(pet).where(memberIdPredicate).fetch();
        List<FindPetDto> findPetDtos = pets
                .stream()
                .map(FindPetDto::of)
                .collect(Collectors.toList());

        return findPetDtos;
    }
}
