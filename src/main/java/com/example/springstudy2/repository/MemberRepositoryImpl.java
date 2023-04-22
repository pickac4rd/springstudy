package com.example.springstudy2.repository;

import com.example.springstudy2.vo.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepositoryImpl implements MemberRepository{

    @PersistenceContext
    private EntityManager em;

    public MemberRepositoryImpl() {
    }

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

}
