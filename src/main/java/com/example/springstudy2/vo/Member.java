package com.example.springstudy2.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String userId;
    private String password;
    private String email;
    private String name;
    private String role;

    public Member(Long id, String userId, String password, String email, String name,String role) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public Member() {
    }
}
