package com.example.apispring.controller;

import com.example.apispring.dto.*;
import com.example.apispring.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    @PostMapping("/")
    public ResponseEntity<PetResponseDto> enrollPet(@RequestBody PetRequestDto petRequestDto) {
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
