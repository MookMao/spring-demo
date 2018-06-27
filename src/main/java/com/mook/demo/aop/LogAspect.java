package com.mook.demo.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: maojunkai
 * @Date: 2018/6/27 上午11:05
 * @Description:
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    @SuppressWarnings(value = "unchecked")
    @Around("@annotation(com.mook.demo.aop.LogAnnotation)")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        Throwable e = null;
        String methodName = getMethodName(joinPoint);
        long startTime = System.currentTimeMillis();

        Object[] parameters = joinPoint.getArgs();
        try {
            log.info("method = {}, parameters = {}", methodName, parameters == null ? null : JSON.toJSONString(parameters));
            result = joinPoint.proceed();
            return result;
        } catch (Throwable ex) {
            e = ex;
            log.warn("method = {}, parameters = {}, exception = {}", methodName, parameters == null ? null : JSON.toJSONString(parameters), ex.getMessage(), ex);
            throw ex;
        } finally {
            long costTime = System.currentTimeMillis() - startTime;
            log.info("method = {}, parameters = {}, result = {}, cost_time = {}", methodName, JSON.toJSONString(parameters), result == null ?
                    null : JSON.toJSONString(result), costTime);

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
