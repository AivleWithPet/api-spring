package com.example.apispring.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;
    private String type;
    private Integer age;
    private String petName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Member member;
}
