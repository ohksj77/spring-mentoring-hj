package com.mentoring.movie.global;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogIntroduction {
    private static final String LOG_FORMAT = "METHOD : {}, ARGS : {}";

    @Pointcut("execution(* com.mentoring.movie..*Controller*.*(..))")
    public void allController() {}

    @Pointcut("execution(* com.mentoring.movie..*Service*.*(..))")
    public void allService() {}

    @Pointcut("execution(* com.mentoring.movie..*Repository*.*(..))")
    public void allRepository() {}

    @Before("allController() || allService() || allRepository()")
    public void controllerLog(final JoinPoint joinPoint) {
        log.info(LOG_FORMAT, joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }
}
