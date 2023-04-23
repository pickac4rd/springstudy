package com.example.springstudy2.controller;

import com.example.springstudy2.repository.MemberRepository;
import com.example.springstudy2.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Transactional
@Controller
public class MemberController {

    @Autowired
    MemberRepository mr;

    @PostMapping("/signup")
    public String signUp(String userId,String password,String name, String email) {
        Member member = new Member();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        member.setName(name);
        member.setUserId(userId);
        member.setPassword(bCryptPasswordEncoder.encode(password));
        member.setEmail(email);
        member.setRole("ROLE_USER");

        mr.save(member);

        System.out.println("sign up");
        return "index";
    }

    @GetMapping("/check")
    public String check(Long id) {
        mr.find(id);
        return "index";
    }

//    @PostMapping("/signin")
//    public String singin(String userId, String password){
//
//    }

}
