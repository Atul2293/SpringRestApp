package com.springboot.features.application.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.springboot.features.application.config.Loggable)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object objectReturned = null;
        long startTime = System.currentTimeMillis();
        objectReturned = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint.getTarget(), timeTaken);
        return  objectReturned;
    }
}
