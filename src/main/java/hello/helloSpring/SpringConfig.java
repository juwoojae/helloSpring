package hello.helloSpring;

import hello.helloSpring.repository.Memberrepository;
import hello.helloSpring.repository.MemoryMemberRepository;
import hello.helloSpring.sevice.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean //Bean 이래로 스트링 빈에 등록할거야
    public MemberService memberService(){
        return new MemberService(memberrepository());
    }
    @Bean
    public Memberrepository memberrepository(){
        return new MemoryMemberRepository();
    }
}
