package com.example.apispring.controller;

import com.example.apispring.dto.ChangePasswordRequestDto;
import com.example.apispring.dto.MemberRequestDto;
import com.example.apispring.dto.MemberResponseDto;
import com.example.apispring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
        MemberResponseDto myInfoBySecurity = memberService.getMyInfoBySecurity();
        System.out.println(myInfoBySecurity.getName());
        return ResponseEntity.ok((myInfoBySecurity));
        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
    }

    @PostMapping("/changeName")
    public ResponseEntity<MemberResponseDto> setName(@RequestBody MemberRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberName(request.getEmail(), request.getName()));
    }

    @PostMapping("/changePw")
    public ResponseEntity<MemberResponseDto> setMemberPassword(@RequestBody ChangePasswordRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberPassword(request.getExPassword(), request.getNewPassword()));
    }

}
