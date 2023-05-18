package com.example.apispring.controller;

import com.example.apispring.domain.Member;
import com.example.apispring.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    //test
    public String index() {
        return "index";
    }
    @GetMapping("/add")
    public String add(){
        return "addform";
    }
    @PostMapping("/add")
    public String addMember(@ModelAttribute("member") Member member,
                            RedirectAttributes redirectAttributes) {
        Member savedmember = memberRepository.save(member);
        redirectAttributes.addAttribute("userid",savedmember.getUserid());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/{userid}";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members1",members);

        return "memberlist";
    }
//test
    @GetMapping("/{userid}")
    public String member(@PathVariable String userid, Model model) {
        Member member = memberRepository.findByUserId(userid);
        model.addAttribute("member", member);

        return "member";
    }

    @GetMapping("/{userid}/edit")
    public String updateformshow(@PathVariable String userid, Model model) {
        Member member = memberRepository.findByUserId(userid);
        model.addAttribute("member",member);

        return "updateInfo";
    }

    @PostMapping("/{userid}/edit")
    public String update(@PathVariable String userid,
                         @ModelAttribute("member") Member updatedmember) {
        memberRepository.updateMemberInfo(userid, updatedmember);

        return "redirect:/{userid}";
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
