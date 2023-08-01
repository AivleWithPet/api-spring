package com.example.apispring.controller;

import com.example.apispring.dto.*;
import com.example.apispring.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/result")
    public ResponseEntity<ResultResponseDto> result(@RequestBody ModelRequestDto modelRequestDto) {
        return ResponseEntity.ok(petService.result(modelRequestDto));
    }
    @GetMapping("/myPets")
    public ResponseEntity<List<PetResponseDto>> getMyPets(@RequestParam(name = "memberId") Long memberId){
        return ResponseEntity.ok(petService.getMyPets(memberId));
    }
}
