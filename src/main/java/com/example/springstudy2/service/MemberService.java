package com.example.springstudy2.service;

import com.example.springstudy2.vo.Member;

import java.util.Optional;

public interface MemberService {
    Long save(Member member);

    Member find(Long id);

    Optional<Member> findByUserId(String userId);

    Optional<Member> findByUserEmail(String email);

    void checkDuplication(Member member);

}
