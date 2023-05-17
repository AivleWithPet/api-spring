package com.example.apispring.controller;

import com.example.apispring.domain.Member;
import com.example.apispring.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
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

    /**
     * 태스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        memberRepository.save(new Member("태호1", "taeho1", "1234"));
        memberRepository.save(new Member("태호2", "taeho2", "1235"));
        memberRepository.save(new Member("태호3", "taeho3", "1236"));
        memberRepository.save(new Member("태호4", "taeho4", "1237"));
    }
}
