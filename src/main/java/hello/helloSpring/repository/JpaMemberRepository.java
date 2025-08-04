package hello.helloSpring.repository;

import hello.helloSpring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.*;

public class JpaMemberRepository implements Memberrepository{
    //JPA는 em 객체로 모든동작을 한다
    //jpa 라이브러리를 임포트 해주면 스프링부트가 자동으로 em 을 생성을 해준다
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //void persist(Object)
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member =em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result =em.createQuery("select m from Member m where m.name = : name", Member.class)
                .setParameter("name",name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //JPQL 에서 쿼리언어 . 객체를 대상으로 쿼리를 날려서 SQL로 번역이 된다
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
