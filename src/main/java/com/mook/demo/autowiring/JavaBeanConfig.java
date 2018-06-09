package com.mook.demo.autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: maojunkai
 * @Date: 2018/6/9 下午4:54
 */
@Configuration
public class JavaBeanConfig {

    @Bean
    public ComputerBook computerBook() {
        return new ComputerBook();
    }
}
