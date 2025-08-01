package hello.helloSpring.sevice;
//회원 서비스 개발

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.Memberrepository;
import hello.helloSpring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final Memberrepository memberrepository = new MemoryMemberRepository();

    /*
     * 회원 서비스 개발
     * */
    private void validateDublicateMember(Member member) {
        memberrepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    public Long join(Member member) {
        //같은 이름이 있는 중복회원 X
        validateDublicateMember(member);
        //Optional<Member> 에 내장되어있는 메서드이다
        memberrepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberrepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberrepository.findById(memberId);
    }
}
