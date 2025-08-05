package hello.helloSpring;

import hello.helloSpring.aop.TimeTraceAop;
import hello.helloSpring.repository.JdbcTemplateMemberRepository;
import hello.helloSpring.repository.JpaMemberRepository;
import hello.helloSpring.repository.Memberrepository;
import hello.helloSpring.repository.MemoryMemberRepository;
import hello.helloSpring.sevice.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final Memberrepository memberrepository;
    @Autowired
    public SpringConfig(Memberrepository memberrepository) {
        this.memberrepository = memberrepository;
    }
    //private EntityManager em;

//   @Autowired
//   public SpringConfig(EntityManager em) {
//       this.em = em;
//   }
    //private final DataSource dataSource;

//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource =dataSource;
//    }
    @Bean //Bean 이래로 스트링 빈에 등록할거야
    public MemberService memberService(){
        return new MemberService(memberrepository);
    }
//    @Bean
//    public Memberrepository memberrepository(){
//        // return new MemoryMemberRepository();
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//
//   }
}
