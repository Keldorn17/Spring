package com.keldorn.aspectorientedprogramming.aspect;

import com.keldorn.aspectorientedprogramming.dto.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

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
            pointcut = "execution(* com.keldorn.aspectorientedprogramming.dao.AccountDao.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        System.out.println("=====>>> Executing @AfterReturning on method: " + joinPoint.getSignature().toShortString());

        System.out.println("=====>>> result is: " + result);
    }
}
