package com.keldorn.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDeclarations {

    // ()   -> matches on method with no arguments
    // (*)  -> matches on method with one argument of any type
    // (..) -> matches on method with 0 or more arguments of any type
    // execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
    // patterns with [?] is optional
    @Pointcut("execution(* com.keldorn.aspectorientedprogramming.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.keldorn.aspectorientedprogramming.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.keldorn.aspectorientedprogramming.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
