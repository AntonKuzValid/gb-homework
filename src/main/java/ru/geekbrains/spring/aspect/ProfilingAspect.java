package ru.geekbrains.spring.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
@EnableAspectJAutoProxy
public class ProfilingAspect {

    @Around("execution(* ru.geekbrains.spring.controller.ProductController.*(..))")
    public Object logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Step in: " + joinPoint.getSignature().getName());
        long time = System.currentTimeMillis();
        try {
            Object retrieveValue = joinPoint.proceed();
            log.info(joinPoint.getSignature().getName() + ": Elapsed time = " + (System.currentTimeMillis() - time) + " msec");
            return retrieveValue;
        } finally {
            log.info("Out of: " + joinPoint.getSignature().getName());
        }
    }
}
