package com.example.apispring.controller;

import com.example.apispring.dto.PetRequestDto;
import com.example.apispring.dto.PetResponseDto;
import com.example.apispring.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    @PostMapping("/")
    public ResponseEntity<PetResponseDto> enrollPet(@RequestBody PetRequestDto petRequestDto) {
        return ResponseEntity.ok(petService.enroll(petRequestDto));
    }
}
