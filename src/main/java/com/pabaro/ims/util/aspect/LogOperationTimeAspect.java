package com.pabaro.ims.util.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogOperationTimeAspect {

    @Around("@annotation(com.pabaro.ims.util.LogOperationTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object proceeded = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Execution Time|{}",endTime - startTime);
        return proceeded;
    }
}
