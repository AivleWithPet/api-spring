package com.example.apispring.controller;

import com.example.apispring.dto.*;
import com.example.apispring.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    @PostMapping("/")
    public ResponseEntity<PetResponseDto> enrollPet(@RequestParam("photo") MultipartFile file,
                                                    @RequestParam("name") String name,
                                                    @RequestParam("species") String species,
                                                    @RequestParam("birth") String birth,
                                                    @RequestParam("info") String info) {
        PetRequestDto petRequestDto = new PetRequestDto(species,Integer.parseInt(birth),name,info);
        return ResponseEntity.ok(petService.enroll(petRequestDto));
    }

    @PostMapping(value= "/result", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ResultResponseDto> result(
            @RequestParam("petId") Long petId,
            @RequestParam("result") String result,
            @RequestPart MultipartFile imageFile
    ) {

        try {
            ModelRequestDto modelRequestDto = new ModelRequestDto();
            modelRequestDto.setPetId(petId);
            modelRequestDto.setResult(result);
            modelRequestDto.setImageFile(imageFile);

            return ResponseEntity.ok(petService.result(modelRequestDto));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/myPets")
    public ResponseEntity<List<PetResponseDto>> getMyPets(@RequestParam(name = "memberId") Long memberId){
        return ResponseEntity.ok(petService.getMyPets(memberId));
    }
}
