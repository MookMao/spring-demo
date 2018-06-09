package com.mook.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @Author: maojunkai
 * @Date: 2018/6/9 下午4:12
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-spring.xml");
        System.out.println(context.getBean("person").getClass().getName());
        System.out.println(context.getBean("javaBeanConfig").getClass().getName());
        System.out.println(context.getBean("computerBook").getClass().getName());
    }
}
