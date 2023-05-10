package com.example.springstudy2.service;

import com.example.springstudy2.vo.Member;

import java.util.Optional;

public interface MemberService {
    Long save(Member member);

    Member find(Long id);

    Optional<Member> findByUserId(String userId);

    Optional<Member> findByUserEmail(String email);

    void checkDuplication(Member member);

<<<<<<< HEAD
    void checkUserId(String userId);
    void checkPassword(String password);
    void checkEmail(String email);
    void checkName(String name);

=======
    int changeRole(Member member);
>>>>>>> 66568912fb558e8653b5280e964d4f8ef23ae766
}
