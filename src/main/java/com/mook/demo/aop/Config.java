package com.mook.demo.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: maojunkai
 * @Date: 2018/6/27 上午11:19
 * @Description:
 */
@Configuration
@ComponentScan
@ImportResource("config-spring.xml")
public class Config {
}
