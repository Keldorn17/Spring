package com.keldorn.aspectorientedprogramming.aspect;

import com.keldorn.aspectorientedprogramming.dto.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Pointcut("execution(* com.keldorn.aspectorientedprogramming.dao.AccountDao.findAccounts(..))")
    private void findAccountsAdvice() {}

    @Before("com.keldorn.aspectorientedprogramming.aspect.AopDeclarations.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("=====>>> Executing @Before advice on " + joinPoint.getSignature().getName() + "()");
        System.out.println("\tMethod Signature: " + joinPoint.getSignature());
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> {
                    if (o instanceof Account account) {
                        System.out.printf("\t%s: [name -> %s, level -> %s]\n",
                                account.getClass().getSimpleName(), account.getName(), account.getLevel());
                        return;
                    }
                    System.out.printf("\t%s: %s\n", o.getClass().getSimpleName(), o);
                });
    }

    @AfterReturning(
            pointcut = "findAccountsAdvice()",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        System.out.println("=====>>> Executing @AfterReturning on method: " + joinPoint.getSignature().toShortString());

        System.out.println("=====>>> result is: " + result);

        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> accounts) {
        accounts.forEach(a -> a.setName(a.getName().toUpperCase()));
    }

    @AfterThrowing(
            pointcut = "findAccountsAdvice()",
            throwing = "throwable")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable throwable) {

        System.out.println("=====>>> Executing @AfterThrowing on method: " + joinPoint.getSignature().toShortString());
        System.out.println("=====>>> The exception is: " + throwable);
    }

    @After("findAccountsAdvice()")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("=====>>> Executing @After (finally) on method: " + joinPoint.getSignature().toShortString());
    }

    @Around("execution(* com.keldorn.aspectorientedprogramming.service.*.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("=====>>> Executing @After (finally) on method: " + proceedingJoinPoint.toShortString());

        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long finish = System.currentTimeMillis();
        System.out.println("Runtime: " + ((double) finish - begin) / 1000 + "s");

        return result;
    }
}
