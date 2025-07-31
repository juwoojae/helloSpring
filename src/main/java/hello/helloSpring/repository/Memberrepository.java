package hello.helloSpring.repository;

import hello.helloSpring.domain.Member;

import java.util.Optional;
import java.util.List;

public interface Memberrepository {
    Member save(Member member);

    Optional<Member> findById(Long id);  //Optional 은 받아오는 값이 null값인경우 Optional로 감싸서 받는다고 한다

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
