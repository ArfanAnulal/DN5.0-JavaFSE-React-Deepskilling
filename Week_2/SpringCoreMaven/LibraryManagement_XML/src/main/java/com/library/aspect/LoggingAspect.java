package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP BEFORE] Executing method: " + joinPoint.getSignature().getName());
    }

    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP AFTER] Completed method: " + joinPoint.getSignature().getName());
    }

    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        System.out.println("[AOP AROUND] Method '" + joinPoint.getSignature().getName() + "' executed in " + duration + "ms");
        return result;
    }
}
