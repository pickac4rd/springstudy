package com.example.springstudy2.service;

import com.example.springstudy2.repository.MemberRepository;
import com.example.springstudy2.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

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

    @Override
<<<<<<< HEAD
    public void checkUserId(String userId) {
        System.out.println("userId = " + userId);
        if(!Pattern.matches("^[a-zA-Z0-9]{8,12}$",userId)){
            throw new IllegalStateException("아이디는 영어 대/소문자,숫자 8~12자로 입력해주세요.");
        }
    }

    @Override
    public void checkPassword(String password) {
        if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$",password)){
            throw new IllegalStateException("패스워드는 숫자,문자,특수문자 최소 1개를 포함하는 8~16자로 입력해주세요.");
        }
    }

    @Override
    public void checkEmail(String email) {

        if(!Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?",email)){
            throw new IllegalStateException("올바른 이메일 주소를 입력해주세요");
        }
    }

    @Override
    public void checkName(String name) {

        if(!Pattern.matches("^[가-힣]{3,5}",name)){
            throw new IllegalStateException("이름은 한글 3~5자로 입력해주세요.");
        }
    }


=======
    public int changeRole(Member member) {
        return memberRepository.changeRole(member);
    }

>>>>>>> 66568912fb558e8653b5280e964d4f8ef23ae766
}
