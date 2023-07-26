package com.example.apispring.service;

import com.example.apispring.config.SecurityUtil;
import com.example.apispring.dto.ModelRequestDto;
import com.example.apispring.dto.PetRequestDto;
import com.example.apispring.dto.PetResponseDto;
import com.example.apispring.dto.ResultResponseDto;
import com.example.apispring.entity.Member;
import com.example.apispring.entity.Pet;
import com.example.apispring.repository.MemberRepository;
import com.example.apispring.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final MemberRepository memberRepository;


    public PetResponseDto enroll(PetRequestDto petRequestDto) {
        Member member = isMemberCurrent();
        Pet pet = Pet.enrollPet(petRequestDto.getSpecies(), petRequestDto.getBirthYear(), petRequestDto.getPetName(), petRequestDto.getInfo(), member);
        return PetResponseDto.of(petRepository.save(pet));
    }

    public Member isMemberCurrent() {
        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
    }

    public ResultResponseDto result(ModelRequestDto modelRequestDto) {

    }
}
