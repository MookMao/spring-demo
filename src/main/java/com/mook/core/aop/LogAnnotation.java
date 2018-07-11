package com.mook.core.aop;

import java.lang.annotation.*;

/**
 * @Author: maojunkai
 * @Date: 2018/6/27 上午11:04
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LogAnnotation {
}
