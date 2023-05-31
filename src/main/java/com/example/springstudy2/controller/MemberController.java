package com.example.springstudy2.controller;

import com.example.springstudy2.repository.MemberRepository;
import com.example.springstudy2.response.ApiResponse;
import com.example.springstudy2.service.MemberService;
import com.example.springstudy2.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute Member member) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRole("ROLE_USER");

        memberService.checkDuplication(member);
        memberService.save(member);

        return "index";
    }

    @GetMapping("/check")
    public String check(Long id) {
        memberService.find(id);
        return "index";
    }

    @GetMapping("/user/test")
    public String testPage(){
        return "test";
    }

//    @PostMapping("/signin")
//    public String singin(String userId, String password){
//
//    }
    @PutMapping("/admin/change")
    public ApiResponse changeRole(@RequestBody Member member){
        int x = memberService.changeRole(member);
        ApiResponse response;

        if(x==1){
            response = ApiResponse.changeRoleSuccess();
        }else {
            response = ApiResponse.changeRoleFail();
        }

        return response;
    }
}
