package com.example.apispring.controller;

import com.example.apispring.data.dto.MemberDto;
import com.example.apispring.domain.Member;
import com.example.apispring.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String add(){
        return "addform";
    }

    @PostMapping("/add")
    public String createMember(MemberDto memberDto, //@RequestParam 쓰지마셈!!! 쓰면 Dto로 안받아짐.
                                  RedirectAttributes redirectAttributes) {
        MemberDto memberDto1 = memberService.saveMember(memberDto.getMemberId(), memberDto.getName(), memberDto.getPassword());
        redirectAttributes.addAttribute("memberId",memberDto1.getMemberId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/{memberId}";
    }
    @GetMapping("/{memberId}")
    public String getMember(@PathVariable String memberId, Model model) {
        MemberDto member = memberService.getMember(memberId);
        model.addAttribute("member", member);

        return "member";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<MemberDto> all = memberService.findAll();
        model.addAttribute("members1",all);

        return "memberlist";
    }

    @GetMapping("/{memberId}/edit")
    public String updateformshow(@PathVariable String memberId, Model model) {
        MemberDto member = memberService.getMember(memberId);
        model.addAttribute("member",member);

        return "updateInfo";
    }

    @PostMapping("/{memberId}/edit")
    public String update(@PathVariable String memberId,
                         MemberDto updatememberDto) {
        memberService.updateMemberInfo(memberId,updatememberDto.getName(), updatememberDto.getPassword());

        return "redirect:/{memberId}";
    }
}
