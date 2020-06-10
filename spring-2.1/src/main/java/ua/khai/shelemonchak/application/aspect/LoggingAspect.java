package ua.khai.shelemonchak.application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger("");

    @Before("execution(* ua.khai.shelemonchak.application.*.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.isTraceEnabled();
        log.info("Start of method \"" + joinPoint.getSignature().getName() + "\"" + " with parameters " + Arrays.toString(joinPoint.getArgs()));

    }
    @After("execution(* ua.khai.shelemonchak.application.*.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {

        log.info("End of method \"" + joinPoint.getSignature().getName() + "\"");
    }

}
