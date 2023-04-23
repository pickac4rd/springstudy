package com.example.springstudy2.security;

import com.example.springstudy2.vo.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityMember extends User {
    public SecurityMember(Member member){
        super(member.getUserId(),member.getPassword(),makeGrantedAuthority());
    }

    private static List<GrantedAuthority> makeGrantedAuthority(){
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return list;
    }
}
