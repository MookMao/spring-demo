package com.mook.demo.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: maojunkai
 * @Date: 2018/6/27 下午11:57
 * @Description:
 */
@Component
@Aspect
@Order(1)
@Slf4j
public class CalculatorLoggingAspect {

//    private static String PATH = "execution(* *.*(..))";
    private static final String PATH = "execution(* CalculateService.add(..))";

    @Before(PATH)
    public void logBefore(JoinPoint joinPoint) {
        // 可以访问当前连接点的细节
        log.info("The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    @After(PATH)
    public void logAfter(JoinPoint joinPoint) {
        // 可以访问当前连接点的细节
        log.info("The method " + joinPoint.getSignature().getName()
                + "() ends with After");
    }

    @AfterReturning(pointcut = PATH, returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // 可以访问当前连接点的细节
        log.info("The method " + joinPoint.getSignature().getName()
                + "() ends with AfterReturning");
    }

    @AfterThrowing(pointcut = PATH, throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        // 可以访问当前连接点的细节
        log.info("An exception " + e + " has bean throwing in " + joinPoint.getSignature().getName());
    }

    @Around(PATH)
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();
        try {
            log.info("method = {}, parameters = {}", methodName,
                    parameters == null ? null : JSON.toJSONString(parameters));
            result = joinPoint.proceed();
            return result;
        } catch (Throwable e) {
            log.warn("method = {}, parameters = {}, exception = {}", methodName,
                    parameters == null ? null : JSON.toJSONString(parameters), e.getMessage(), e);
            throw e;
        } finally {
            log.info("method = {}, parameters = {}, result = {}", methodName,
                    JSON.toJSONString(parameters), result == null ? null : JSON.toJSONString(result));

        }
    }
}
