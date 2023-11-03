package com.adrian.memberapi.repository;

import com.adrian.memberapi.model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository implements CustomJPARepository<Member, Long>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Member find(Long id) {
        return entityManager.find(Member.class, id);
    }

    @Override
    public List<Member> findAll() {
        return entityManager.createQuery("SELECT m FROM Member m", Member.class).getResultList();
    }

    @Override
    public Member save(Member member) {
        if(member.getId() == null){
            entityManager.persist(member);
        } else {
            entityManager.merge(member);
        }
        return member;
    }

    @Override
    public void delete(Long id) {
        Member member = find(id);
        if(member != null){
            entityManager.remove(member);
        }
    }
}
