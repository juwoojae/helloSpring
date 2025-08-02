package hello.helloSpring.sevice;
//회원 서비스 개발

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.Memberrepository;
import hello.helloSpring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional; //비즈니스 로직을 만들고
public class MemberService {
    private final Memberrepository memberrepository ;

    public MemberService(Memberrepository memberrepository){
        this.memberrepository=memberrepository;
    }  //생성자로서 넣어주기
    /*
     * 회원 서비스 개발
     * */
    private void validateDublicateMember(Member member) {
        memberrepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 멤버 회원가입 기능, 메서드가 추가된 멤버의 id를 리턴한다
    public Long join(Member member) {
        //같은 이름이 있는 중복회원 X
        validateDublicateMember(member);
        //Optional<Member> 에 내장되어있는 메서드이다
        memberrepository.save(member);
        return member.getId();
    }

    // 모든 회원 리턴
    public List<Member> findMembers() {
        return memberrepository.findAll();
    }

    //회원의 유무 확인기능
    public Optional<Member> findOne(Long memberId) {
        return memberrepository.findById(memberId);
    }
}
