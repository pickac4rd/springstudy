package com.example.springstudy2.security;

import com.example.springstudy2.repository.MemberRepository;
import com.example.springstudy2.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberDetailService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) {

        Optional<Member> member = memberRepository.findByUserId(userId);
        SecurityMember smember;

        if(!member.isPresent())
            throw new InternalAuthenticationServiceException("계정이 존재하지 않습니다.");

        return memberRepository.findByUserId(userId)
                .map(SecurityMember::new)
                .get();
    }

}
