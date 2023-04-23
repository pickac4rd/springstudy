package com.example.springstudy2.repository;

import com.example.springstudy2.vo.Member;

import java.util.Optional;

public interface MemberRepository {
    Long save(Member member);

    Member find(Long id);

    Optional<Member> findByUserId(String userId);

    Optional<Member> findByUserEmail(String email);

}
