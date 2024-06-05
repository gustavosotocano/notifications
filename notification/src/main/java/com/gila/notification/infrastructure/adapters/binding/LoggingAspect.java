package com.gila.notification.infrastructure.adapters.binding;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.gila.notification.domain.implementation.*.*(..))" +
            " execution(* com.gila.notification.infrastructure.adapters.repositories.*.*(..))" +
            " execution(* com.gila.notification.domain.services.*.*(..))"
    ) // Pointcut example
    public void allPackageMethods() {}

    @Before("allPackageMethods()")
    public void logBeforeMethod(JoinPoint joinPoint) {
        log.info("Invoking method: {} with params {} " , joinPoint.getSignature(),joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "allPackageMethods()", returning = "returnValue")
    public void logAfterReturningMethod(JoinPoint joinPoint, Object returnValue) {
        log.info("Method completed successfully:{} , valor de retorno: {}" , joinPoint.getSignature() , returnValue);
    }

    @AfterThrowing(pointcut = "allPackageMethods()", throwing = "ex")
    public void logAfterThrowingMethod(JoinPoint joinPoint, Exception ex) {
        log.error("Error when invoking method:s {} {} ,exception" , joinPoint.getSignature(),  ex.getMessage(),ex);
    }
}