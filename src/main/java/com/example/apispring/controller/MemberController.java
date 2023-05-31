package com.example.apispring.controller;

import com.example.apispring.data.JsonConverter;
import com.example.apispring.data.ai.DjangoClient;
import com.example.apispring.data.ai.ModelData;
import com.example.apispring.data.dto.IrisDataDto;
import com.example.apispring.data.dto.MemberDto;
import com.example.apispring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
    @GetMapping("/{memberId}/delete")
    public String delete(@PathVariable String memberId) {
        memberService.deleteMember(memberId);

        return "redirect:/members";
    }

    @GetMapping("/modelresult")
    public String irisdataform() {

        return "irisdataform";
    }

    @PostMapping("/model_result")
    public String classificationResult(ModelData modelData) {
        System.out.println(modelData);
        System.out.println(modelData.getPrediction());

//        DjangoClient.sendDataToDjango("http://localhost:8000/ai/",jsonData);
        return "index";
    }
//
//    @GetMapping("/model_result")
}
