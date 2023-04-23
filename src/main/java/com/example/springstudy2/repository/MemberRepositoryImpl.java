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

    @Override
    public Member find(Long id) {
        Member member;
        member = em.createQuery("select m from Member m where m.id=:id",Member.class).setParameter("id",id).getSingleResult();
        System.out.println(member.getName());
        return member;
    }

    @Override
    public Member findByUserId(String userid) {
        Member member;
        member = em.createQuery("select m from Member m where m.userId=:userid",Member.class)
                .setParameter("userid",userid).getSingleResult();
        return member;
    }

}
