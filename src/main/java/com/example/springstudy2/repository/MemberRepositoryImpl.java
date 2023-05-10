package com.example.springstudy2.repository;

import com.example.springstudy2.vo.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public MemberRepositoryImpl() {
    }

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    @Override
    public Member find(Long id) {
        Member member;
        member = em.createQuery("select m from Member m where m.id=:id", Member.class).setParameter("id", id).getSingleResult();
        System.out.println(member.getName());
        return member;
    }

    @Override
    public Optional<Member> findByUserId(String userid) {
        Optional<Member> member = null;
        try {
            member = Optional.ofNullable(em.createQuery("select m from Member m where m.userId=:userid", Member.class)
                    .setParameter("userid", userid).getSingleResult());
        } catch (NoResultException e) {
            member = Optional.empty();
        } finally {
            return member;
        }

    }

    public Optional<Member> findByUserEmail(String email) {
        Optional<Member> member = null;
        try {
            Optional.ofNullable(em.createQuery("select m from Member m where m.email=:email", Member.class)
                    .setParameter("email", email).getSingleResult());
        } catch (NoResultException e) {
            member = Optional.empty();
        } finally {
            return member;
        }
    }

//    @Override
//    public int changeRole(Member member) {
//
//    }


}
