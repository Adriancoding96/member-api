package com.adrian.memberapi.repository;

import com.adrian.memberapi.model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository implements CustomJPARepository<Member, Long>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Member> find(Long id) {
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
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
        Optional<Member> member = find(id);
        member.ifPresent(value -> entityManager.remove(value));
    }
}
