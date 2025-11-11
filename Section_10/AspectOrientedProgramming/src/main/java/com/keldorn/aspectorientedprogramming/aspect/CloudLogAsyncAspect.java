package com.keldorn.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CloudLogAsyncAspect {

    @Before("com.keldorn.aspectorientedprogramming.aspect.AopDeclarations.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {

        System.out.println("=====>>> Logging to Cloud in async");
    }
}
