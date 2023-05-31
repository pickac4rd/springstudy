package com.example.springstudy2.security;

import com.example.springstudy2.vo.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class SecurityMember extends User {

    private final Member member;

    public SecurityMember(Member member){
        super(member.getUserId(),member.getPassword(),makeGrantedAuthority());
        this.member = member;
    }

    private static List<GrantedAuthority> makeGrantedAuthority(){
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        list.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return list;
    }
}
