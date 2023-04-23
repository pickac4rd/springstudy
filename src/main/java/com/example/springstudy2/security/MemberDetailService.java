package com.example.springstudy2.security;

import com.example.springstudy2.repository.MemberRepository;
import com.example.springstudy2.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Optional<Member> member = memberRepository.findByUserId(userId);

        return memberRepository.findByUserId(userId)
                .filter(m->m!=null)
                .map(SecurityMember::new)
                .get();
    }

}
