package com.example.springstudy2.service;

import com.example.springstudy2.repository.MemberRepository;
import com.example.springstudy2.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Long save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member find(Long id) {
        return memberRepository.find(id);
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        return memberRepository.findByUserId(userId);
    }

    @Override
    public Optional<Member> findByUserEmail(String email) {
        return memberRepository.findByUserEmail(email);
    }

    @Override
    public void checkDuplication(Member member) {
        Optional<Member> checkMemberById = findByUserId(member.getUserId());
        if (checkMemberById.isPresent())
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        Optional<Member> checkMemberByEmail = findByUserEmail(member.getEmail());
        if (checkMemberByEmail.isPresent())
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
    }

}
