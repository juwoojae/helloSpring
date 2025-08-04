package hello.helloSpring.repository;

import hello.helloSpring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Spring Data JPA가 제공하는 기본 CRUD 기능 (save, findById 등)을 자동으로 사용할 수 있게 해줍니다.
//Memberrepository 의 상속받은 클래스 (구현 인터페이스이다) 얘는 JPaRepository를 임포트 하는 순간 구현체를 알아서 포함시켜준다 오잉??
//
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> ,Memberrepository{
    //JPOL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
