package com.mook.core.aop;

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

    /**
     * 必须为final String类型的,注解里要使用的变量只能是静态常量类型的
     */
    private static final String PATH = "execution(* CalculateService.add(..))";

    @Pointcut("execution(* CalculateService.add(..))")
    public void add() {}

    /**
     * 前置通知：目标方法调用之前执行的代码
     * @param joinPoint
     */
    @Before("add()")
    public void logBefore(JoinPoint joinPoint) {
        // 可以访问当前连接点的细节
        log.info("The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 后置通知：目标方法调用之后执行的代码（无论目标方法是否出现异常均执行）
     * 因为方法可能会出现异常，所以不能返回方法的返回值
     * @param joinPoint
     */
    @After(PATH)
    public void logAfter(JoinPoint joinPoint) {
        // 可以访问当前连接点的细节
        log.info("The method " + joinPoint.getSignature().getName()
                + "() ends with After");
    }

    /**
     * 后置返回通知：目标方法正常结束后执行的代码
     * 返回通知是可以访问到目标方法的返回值的
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = PATH, returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // 可以访问当前连接点的细节
        log.info("The method " + joinPoint.getSignature().getName()
                + "() ends with AfterReturning");
    }

    /**
     * 异常通知：目标方法抛出异常时执行的代码
     * 可以访问到异常对象
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = PATH, throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        // 可以访问当前连接点的细节
        log.info("An exception " + e + " has bean throwing in " + joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知：目标方法调用前后执行的代码，可以在方法调用前后完成自定义的行为。
     * 包围一个连接点（join point）的通知。它会在切入点方法执行前执行,方法结束也会执行对应的部分。
     * 主要是调用proceed()方法来执行切入点方法，来作为环绕通知前后方法的分水岭。
     *
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
     * 如果目标方法有返回值，环绕通知必须有返回值
     * @param joinPoint
     * @return
     * @throws Throwable
     */
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
