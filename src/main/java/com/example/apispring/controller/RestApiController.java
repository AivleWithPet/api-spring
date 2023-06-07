//package com.example.apispring.controller;
//
//import com.example.apispring.data.dto.MemberDto;
//import com.example.apispring.data.dto.RegistrationDto;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//public class RestApiController {
//
// private final MemberService memberService;
//
////    @PostMapping("/register")
////    public ResponseEntity<String> registerUser(@RequestBody RegistrationDto registrationRequest,
////                                               RedirectAttributes redirectAttributes) {
////        String email = registrationRequest.getEmail();
////        String username = registrationRequest.getUsername();
////        String password = registrationRequest.getPassword();
////
////        MemberDto memberDto1 = memberService.saveMember(email, username, password);
////        redirectAttributes.addAttribute("memberId",memberDto1.getMemberId());
////        redirectAttributes.addAttribute("status", true);
////
////        System.out.println(email + username + password);
////
////// return "redirect:/{memberId}";
////        return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다");
////    }
//
//    @PostMapping("/register")
//    public void registerUser(@RequestBody RegistrationDto registrationRequest,
//                                               RedirectAttributes redirectAttributes,
//                             HttpServletResponse response) throws IOException {
//        String memberId = registrationRequest.getMemberId();
//        String username = registrationRequest.getUsername();
//        String password = registrationRequest.getPassword();
//
//        MemberDto memberDto1 = memberService.saveMember(memberId, username, password);
//        redirectAttributes.addAttribute("memberId",memberDto1.getMemberId());
//        redirectAttributes.addAttribute("status", true);
//
//        System.out.println(memberId + username + password);
//        // String redirect_uri="http://localhost:8080/members";
//        // response.sendRedirect(redirect_uri);
////        return "redirect:/{memberId}";
////        return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다");
//    }
//
//
//// @PostMapping("/add")
//// public String createMember(MemberDto memberDto, //@RequestParam 쓰지마셈!!! 쓰면 Dto로 안받아짐.
//// RedirectAttributes redirectAttributes) {
//// MemberDto memberDto1 = memberService.saveMember(memberDto.getMemberId(), memberDto.getName(), memberDto.getPassword());
//// redirectAttributes.addAttribute("memberId",memberDto1.getMemberId());
//// redirectAttributes.addAttribute("status", true);
//// return "redirect:/{memberId}";
//// }
//}