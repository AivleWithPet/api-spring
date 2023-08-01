package com.example.apispring.service;

import com.example.apispring.config.SecurityUtil;
import com.example.apispring.dto.*;
import com.example.apispring.entity.Diagnosis;
import com.example.apispring.entity.Disease;
import com.example.apispring.entity.Member;
import com.example.apispring.entity.Pet;
import com.example.apispring.repository.DiagnosisRepository;
import com.example.apispring.repository.MemberRepository;
import com.example.apispring.repository.PetDiseaseRepository;
import com.example.apispring.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final PetDiseaseRepository petDiseaseRepository;
    private final MemberRepository memberRepository;
    private final DiagnosisRepository diagnosisRepository;


    public PetResponseDto enroll(PetRequestDto petRequestDto) {
        Member member = isMemberCurrent();
        Pet pet = Pet.enrollPet(petRequestDto.getSpecies(), petRequestDto.getBirthYear(), petRequestDto.getPetName(), petRequestDto.getInfo(), member);
        return PetResponseDto.of(petRepository.save(pet));
    }

    public Member isMemberCurrent() {
        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
    }

    public ResultResponseDto result(ModelRequestDto modelRequestDto) throws IOException {

        MultipartFile imageFile = modelRequestDto.getImageFile();
        String diseaseName = modelRequestDto.getResult();
        Long petId = modelRequestDto.getPetId();

//        System.out.println(imageFile);
//        System.out.println(diseaseName);
//        System.out.println(petId);

        // 저장 디렉토리
        String uploadDir = "images";

        // 디렉토리 없을 경우 생성
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // 서버의 파일 시스템에 이미지 파일을 저장합니다.
        String filePath = uploadDir + File.separator + imageFile.getOriginalFilename();
        File dest = new File(filePath);

//        System.out.println("File Name: " + imageFile.getOriginalFilename());
//        System.out.println("Dest Path: " + dest.getAbsolutePath());
//        System.out.println("File Size: " + imageFile.getSize());

        imageFile.transferTo(dest);

        Disease existingDisease = petDiseaseRepository.findByName(diseaseName)
                .orElseThrow(() -> new RuntimeException("해당 질환 정보를 찾을 수 없습니다"));

        Pet existingPet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("해당 펫 정보를 찾을 수 없습니다"));

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDisease(existingDisease);
        diagnosis.setPet(existingPet);
//        diagnosis.setPhotoName(imageFile.getOriginalFilename());
//        diagnosis.setPhotoPath(filePath);

        diagnosis = diagnosisRepository.save(diagnosis);

        ResultResponseDto resultResponseDto = new ResultResponseDto();
        resultResponseDto.setInform(existingDisease.getInform());
        resultResponseDto.setSupplements(existingDisease.getSupplements());
        resultResponseDto.setDiseaseName(existingDisease.getName());

        return resultResponseDto;
    }

    public List<PetResponseDto> getMyPets(Long memberId) {
        return petRepository.searchMyPets(memberId);
    }
}
