package hello.helloSpring.repository;

import hello.helloSpring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach  //각각의 테스트가 끝나고 바로 각각 실행시켜주는 에노테이션
    public void afterEach(){     //모두 같이 test 를 하면 순서에 의존하지 않기때문에 객체를 새로생성해줘도 겹칠수있다 그래서 clear 해줘야함
        repository.clearStore();
    }
    @Test//에노테이션 junit
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        repository.findById(member.getId());

        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member,result);//Nullable Object expected,Object actual
        //Assertj  <- 많이쓴다고 함
        assertThat(member).isEqualTo(result);  //alt + enter 후 import 해주면 assertThat 바로 써줄수 있음
    }

    @Test
    public void findByname() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }
    @Test
    public void findAll(){
        Member member1 =new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 =new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result =repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
