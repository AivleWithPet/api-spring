package com.example.apispring.controller;

import com.example.apispring.data.dto.ChangePasswordRequestDto;
import com.example.apispring.data.dto.MemberRequestDto;
import com.example.apispring.data.dto.MemberResponseDto;
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

    @PostMapping("/name")
    public ResponseEntity<MemberResponseDto> setName(@RequestBody MemberRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberName(request.getMemberId(), request.getName()));
    }

    @PostMapping("/password")
    public ResponseEntity<MemberResponseDto> setMemberPassword(@RequestBody ChangePasswordRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberPassword(request.getExPassword(), request.getNewPassword()));
    }


//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping("/add")
//    public String add(){
//        return "addform";
//    }
//
//    @PostMapping("/add")
//    public String createMember(MemberDto memberDto, //@RequestParam 쓰지마셈!!! 쓰면 Dto로 안받아짐.
//                                  RedirectAttributes redirectAttributes) {
//        MemberDto memberDto1 = memberService.saveMember(memberDto.getMemberId(), memberDto.getName(), memberDto.getPassword());
//        redirectAttributes.addAttribute("memberId",memberDto1.getMemberId());
//        redirectAttributes.addAttribute("status", true);
//        return "redirect:/{memberId}";
//    }
//    @GetMapping("/{memberId}")
//    public String getMember(@PathVariable String memberId, Model model) {
//        MemberDto member = memberService.getMember(memberId);
//        model.addAttribute("member", member);
//
//        return "member";
//    }
//
//    @GetMapping("/members")
//    public String members(Model model) {
//        List<MemberDto> all = memberService.findAll();
//        model.addAttribute("members1",all);
//
//        return "memberlist";
//    }
//
//    @GetMapping("/{memberId}/edit")
//    public String updateformshow(@PathVariable String memberId, Model model) {
//        MemberDto member = memberService.getMember(memberId);
//        model.addAttribute("member",member);
//
//        return "updateInfo";
//    }
//
//    @PostMapping("/{memberId}/edit")
//    public String update(@PathVariable String memberId,
//                         MemberDto updatememberDto) {
//        memberService.updateMemberInfo(memberId,updatememberDto.getName(), updatememberDto.getPassword());
//
//        return "redirect:/{memberId}";
//    }
//    @GetMapping("/{memberId}/delete")
//    public String delete(@PathVariable String memberId) {
//        memberService.deleteMember(memberId);
//
//        return "redirect:/members";
//    }
//
//    @GetMapping("/modelresult")
//    public String irisdataform() {
//
//        return "irisdataform";
//    }
//
//    @PostMapping("/model_result")
//    public String classificationResult(ModelData modelData) {
//        System.out.println(modelData);
//        System.out.println(modelData.getPrediction());
//
////        DjangoClient.sendDataToDjango("http://localhost:8000/ai/",jsonData);
//        return "index";
//    }
////
////    @GetMapping("/model_result")
}
