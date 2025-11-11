package com.keldorn.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAnalyticsAspect {

    @Before("com.keldorn.aspectorientedprogramming.aspect.AopDeclarations.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {

        System.out.println("=====>>> Performing API analytics");
    }
}
