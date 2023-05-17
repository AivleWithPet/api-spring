package com.example.apispring.controller;

import com.example.apispring.domain.Member;
import com.example.apispring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/add")
    public String add(){
        return "addform";
    }
    @PostMapping("/add")
    public String addMember(@ModelAttribute("item") Member member) {
        memberRepository.save(member);
        return "redirect:/";
    }
}
