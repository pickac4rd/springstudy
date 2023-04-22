package com.example.springstudy2.controller;

import com.example.springstudy2.repository.MemberRepository;
import com.example.springstudy2.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Transactional
@Controller
public class MemberController {

    @Autowired
    MemberRepository mr;

    @GetMapping("/member")
    public String test() {
        Member member = new Member();
        member.setName("asd");
        member.setUserId("asdasd");
        member.setPassword("1234");
        member.setEmail("asd@asd");
        Long id = mr.save(member);
        return "index";
    }

}
