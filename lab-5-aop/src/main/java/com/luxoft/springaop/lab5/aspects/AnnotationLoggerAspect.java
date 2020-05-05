package com.luxoft.springaop.lab5.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class AnnotationLoggerAspect {

    private static final Logger LOG = Logger.getLogger(AnnotationLoggerAspect.class.getName());

    @AfterReturning(pointcut = "@annotation(LogResult)", returning = "result")
    public void logResult(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        LOG.info(String.format("Method \"%s\" return: %s", name, result));
    }
}
