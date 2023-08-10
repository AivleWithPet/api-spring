package com.example.apispring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;

    @Column
    private String species;

    @Column
    private Integer birthYear;

    @Column
    private String petName;

    @Column
    private String info;

    @Column
    private String photoPath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static Pet enrollPet (String species,Integer birthYear, String petName, String info , String photoPath, Member member) {
        Pet pet  = new Pet();
        pet.species = species;
        pet.birthYear = birthYear;
        pet.petName = petName;
        pet.info = info;
        pet.photoPath = photoPath;
        pet.member = member;

        return pet;
    }
}
