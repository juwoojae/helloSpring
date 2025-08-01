package hello.helloSpring.sevice;

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach  //BeforeEach 에노테이션 각각의 테스트 메서드를 실행하기 전에 실행되는 부분
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach  //각각의 테스트
    public void afterEach() {     //모두 같이 test 를 하면 순서에 의존하지 않기때문에 객체를 새로생성해줘도 겹칠수있다 그래서 clear 해줘야함
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given   주어진상황에서
        Member member = new Member();
        member.setName("hello");

        //when   이런상황일때
        Long saveId = memberService.join(member);

        //then   이게 나와야 해
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Spring);");

        Member member2 = new Member();
        member2.setName("Spring);");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //try- catch 보다 더 범용성있게 쓰이는 assertThrows 라는 문법을 제공한다
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}