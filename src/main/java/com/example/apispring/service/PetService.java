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
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final PetDiseaseRepository petDiseaseRepository;
    private final MemberRepository memberRepository;
    private final DiagnosisRepository diagnosisRepository;


    public FindPetDto enroll(PetRequestDto petRequestDto) throws IOException {
        Member member = isMemberCurrent();
        MultipartFile profilePhoto = petRequestDto.getPhoto();

        // 저장 디렉토리
        String uploadDir = "src/main/resources/images/profile";
        // 디렉토리 없을 경우 생성
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        // 서버의 파일 시스템에 이미지 파일을 저장합니다.
        String filePath = System.getProperty("user.dir") + "/" + uploadDir + File.separator + profilePhoto.getOriginalFilename();
        System.out.println(filePath);
        File dest = new File(filePath);
        profilePhoto.transferTo(dest);

        Pet pet = Pet.enrollPet(petRequestDto.getSpecies(), petRequestDto.getBirthYear(), petRequestDto.getPetName(), petRequestDto.getInfo(), filePath, member);

        return FindPetDto.of(petRepository.save(pet));
    }

    public Member isMemberCurrent() {
        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
    }

    public ResultResponseDto result(ModelRequestDto modelRequestDto) throws IOException {

        MultipartFile imageFile = modelRequestDto.getImageFile();
        String diseaseName = modelRequestDto.getResult();
        Long petId = modelRequestDto.getPetId();
        Double percentage = modelRequestDto.getPercentage();

        // 저장 디렉토리
        String uploadDir = "src/main/resources/images";

        // 디렉토리 없을 경우 생성
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // 서버의 파일 시스템에 이미지 파일을 저장합니다.
        String filePath = System.getProperty("user.dir") + "/" + uploadDir + File.separator + imageFile.getOriginalFilename();

        File dest = new File(filePath);


        imageFile.transferTo(dest);

        Disease existingDisease = petDiseaseRepository.findByName(diseaseName)
                .orElseThrow(() -> new RuntimeException("해당 질환 정보를 찾을 수 없습니다"));

        Pet existingPet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("해당 펫 정보를 찾을 수 없습니다"));

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDisease(existingDisease);
        diagnosis.setPet(existingPet);
        diagnosis.setPhotoName(imageFile.getOriginalFilename());
        diagnosis.setPhotoPath(filePath);
        diagnosis.setPercentage(percentage);

        diagnosis = diagnosisRepository.save(diagnosis);

        String imageBase64 = encodeImageToBase64(filePath);
        ResultResponseDto resultResponseDto = new ResultResponseDto();
        resultResponseDto.setInform(existingDisease.getInform());
        resultResponseDto.setSupplements(existingDisease.getSupplements());
        resultResponseDto.setDiseaseName(existingDisease.getName());
        resultResponseDto.setPercentage(diagnosis.getPercentage());
        resultResponseDto.setCreatedAt(diagnosis.getCreated_at());
        resultResponseDto.setImageBase64(imageBase64);

        return resultResponseDto;
    }



    private String encodeImageToBase64(String filePath) throws IOException {
        File imageFile = new File(filePath);
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public List<PetResponseDto> getMyPets(Long memberId) {
        List<FindPetDto> findPetDtos = petRepository.searchMyPets(memberId);
        List<PetResponseDto> petResponseDtos = new ArrayList<>();

        for (FindPetDto findPetDto : findPetDtos) {
            PetResponseDto temp = new PetResponseDto();
            temp.setPetName(findPetDto.getPetName());
            temp.setPetId(findPetDto.getPetId());
            temp.setInfo(findPetDto.getInfo());
            temp.setSpecies(findPetDto.getSpecies());
            temp.setBirthYear(findPetDto.getBirthYear());

            // 바이너리 데이터 넣어주기

            byte[] fileData = getFileData(findPetDto.getPhotoPath());

            temp.setPhotoData(Base64.getEncoder().encodeToString(fileData));
            petResponseDtos.add(temp);

        }
        return petResponseDtos;
    }

    public List<ResultResponseDto> getResults(Long petId) {
        List<FindPetDiagnosisDto> findPetDiagnosisDtos = diagnosisRepository.searchDiagnosis(petId);
        List<ResultResponseDto> resultResponseDtoList = new ArrayList<>();

        for( FindPetDiagnosisDto findPetDiagnosisDto : findPetDiagnosisDtos) {
            ResultResponseDto temp = new ResultResponseDto();
            String name = findPetDiagnosisDto.getDisease().getName();
            Disease disease = petDiseaseRepository.findByName(name)
                    .orElseThrow(() -> new RuntimeException("해당 질환 정보를 찾을 수 없습니다"));

            temp.setCreatedAt(findPetDiagnosisDto.getCreatedAt());
            temp.setDiseaseName(name);
            temp.setPercentage(findPetDiagnosisDto.getPercentage());
            temp.setInform(disease.getInform());
            temp.setSupplements(disease.getSupplements());

            byte[] fileData = getFileData(findPetDiagnosisDto.getPhotoPath());
            temp.setImageBase64(Base64.getEncoder().encodeToString(fileData));

            resultResponseDtoList.add(temp);
        }
        return resultResponseDtoList;
    }

    private byte[] getFileData(String filePath) {
        try {
            File file = new File(filePath);
            byte[] fileData = new byte[(int) file.length()];

            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                fileInputStream.read(fileData);
            }

            return fileData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
