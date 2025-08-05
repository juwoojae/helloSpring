package hello.helloSpring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.stereotype.Component;

@Aspect
@Component
//스프링 빈으로 등록을 해주어야 한다
public class TimeTraceAop {
    //적용할 클래스, 메서드 , 패키지를 선택적으로 적용가능하다
    @Around("execution(* hello.helloSpring..*(..)) ")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start=System.currentTimeMillis();
        System.out.println("START: "+ joinPoint.toString()); //어떤 메서드를 콜하는지 알려준다
        try {
            return joinPoint.proceed();
        } finally {
            long finish =System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() +" " +timeMs + "ms");
        }
    }
}
