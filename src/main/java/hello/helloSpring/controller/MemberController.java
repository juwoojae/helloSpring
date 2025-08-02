package hello.helloSpring.controller;

import hello.helloSpring.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//Controller 에노테이션이 있으면 객체를 생성후(springBin),  Spring컨테이너에 넣어둔다
@Controller
public class MemberController {
    //생성자에 @Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.

    private final MemberService memberService;

//    @Autowired                setter 주입 final 빼야함
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }


    @Autowired  //이게 바로 의존관계 설정이다   생성자 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
