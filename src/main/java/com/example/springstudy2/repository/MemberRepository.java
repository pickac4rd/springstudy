package com.example.springstudy2.repository;

import com.example.springstudy2.vo.Member;

public interface MemberRepository {
    Long save(Member member);
    Member find(Long id);
    Member findByUserId(String userId);
}
