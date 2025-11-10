package com.keldorn.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // ()   -> matches on method with no arguments
    // (*)  -> matches on method with one argument of any type
    // (..) -> matches on method with 0 or more arguments of any type
    // execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
    // patterns with [?] is optional
    @Pointcut("execution(* com.keldorn.aspectorientedprogramming.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.keldorn.aspectorientedprogramming.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.keldorn.aspectorientedprogramming.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("=====>>> Executing @Before advice on method()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {

        System.out.println("=====>>> Performing API analytics");
    }
}
