package ua.khai.shelemonchak.application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* ua.khai.shelemonchak.application.*.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("********\n" + "start of method \"" + joinPoint.getSignature().getName() + "\"");

        System.out.println("********");

    }


}
