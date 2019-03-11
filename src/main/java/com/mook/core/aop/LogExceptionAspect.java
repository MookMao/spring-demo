package com.mook.core.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: maojunkai
 * @Date: 2018/6/27 上午11:05
 * @Description: 捕获切面中抛出的异常
 */
@Component
@Aspect
@Order(10)
@Slf4j
public class LogExceptionAspect {
    @SuppressWarnings(value = "unchecked")
    @Around("@annotation(com.mook.core.aop.LogAnnotation)")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        String methodName = getMethodName(joinPoint);

        Object[] parameters = joinPoint.getArgs();
        try {
            log.info("method = {}, parameters = {}", methodName, parameters == null ? null : JSON.toJSONString(parameters));
            result = joinPoint.proceed();
            return result;
        } catch (Throwable ex) {
            log.warn("method = {}, parameters = {}, exception = {}", methodName, parameters == null ? null : JSON.toJSONString(parameters), ex);
            return 11111111;
        }
    }
    /**
     * 获取方法名
     * @param joinPoint
     * @return
     */
    private String getMethodName(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature ms = (MethodSignature) signature;
        Method m = ms.getMethod();

        return m.getName();
    }

}
