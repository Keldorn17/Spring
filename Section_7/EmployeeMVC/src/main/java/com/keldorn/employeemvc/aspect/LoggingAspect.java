package com.keldorn.employeemvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.keldorn.employeemvc.controller.*.*(..))")
    private void controllerPackage() {}

    @Pointcut("execution(* com.keldorn.employeemvc.service.*.*(..))")
    private void servicePackage() {}

    @Pointcut("execution(* com.keldorn.employeemvc.repository.*.*(..))")
    private void repositoryPackage() {}

    @Pointcut("controllerPackage() || servicePackage() || repositoryPackage()")
    private void combinedPackage() {}

    @Before("combinedPackage()")
    public void before(JoinPoint joinPoint) {
        logger.info("=====>>> in @Before: calling method: " + joinPoint.getSignature().toShortString());
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> logger.info("=====>>> argument: " + o));
    }

    @AfterReturning(
            pointcut = "combinedPackage()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("=====>>> in @AfterReturning: calling method: " + joinPoint.getSignature().toShortString());
        logger.info("=====>>> returned data: " + result);
    }
}
