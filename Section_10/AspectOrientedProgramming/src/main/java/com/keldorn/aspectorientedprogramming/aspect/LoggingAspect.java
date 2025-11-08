package com.keldorn.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // ()   -> matches on method with no arguments
    // (*)  -> matches on method with one argument of any type
    // (..) -> matches on method with 0 or more arguments of any type
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.keldorn.aspectorientedprogramming.dao.AccountDao.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.keldorn.aspectorientedprogramming.dto.Account, ..))")
//    @Before("execution(* com.keldorn..add*(..))")
    @Before("execution(* com.keldorn.aspectorientedprogramming.dao.*.*(..))")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method()");
    }
}
