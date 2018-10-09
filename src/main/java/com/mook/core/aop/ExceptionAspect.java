package com.mook.core.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: maojunkai
 * @Date: 2018/6/27 上午11:05
 * @Description: 这个切面的作用就是在目标方法执行前抛出异常
 */
@Component
@Aspect
@Order(11)
@Slf4j
public class ExceptionAspect {
    @Before("@annotation(com.mook.core.aop.LogAnnotation)")
    public void process(JoinPoint joinPoint) {
        throw new RuntimeException();
    }

}
