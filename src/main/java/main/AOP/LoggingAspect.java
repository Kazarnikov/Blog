package main.AOP;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LoggingAspect {


    @Before("execution(* main.controller..get*(..))")
    public void beforeGetControllerAdvice(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        String method = ms.getName();
        Object[] args = joinPoint.getArgs();
        log.info("\u001B[33m + Start in controller method {} transmit: {}\u001B[0m", method, Arrays.asList(args));
    }

    @After("execution(* main.controller..get*(..))")
    public void afterGetControllerAdvice(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        String method = ms.getName();
        log.info("\u001B[33m - End in controller method {}\u001B[0m", method);
    }

    @Before("execution(* main.service.*Impl.*(..))")
    public void beforeServiceAdvice(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        String method = ms.getName();
        Object[] args = joinPoint.getArgs();
        log.info("\u001B[36m + Start in service method {} transmit: {}\u001B[0m", method, Arrays.asList(args));
    }

    @After("execution(* main.service..*(..))")
    public void afterFindServiceAdvice(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        String method = ms.getName();
        log.info("\u001B[36m - End in service method {}\u001B[0m", method);
    }
}
