package com.example.springstudy2.controller;

import com.example.springstudy2.repository.MemberRepository;
import com.example.springstudy2.service.MemberService;
import com.example.springstudy2.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional
@Controller
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

//    @PostMapping("/signin")
//    public String singin(String userId, String password){
//
//    }

}
