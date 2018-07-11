package com.mook.core.autowiring;

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

    /**
     * 实例化id 为 computerBook2的类型为ComputerBook的bean
     * 当使用@Autowired进行注入时，发现有两个Bean类型都为ComputerBook，这时候就根据id来进行过滤
     * @return
     */
    @Bean
    public ComputerBook computerBook2() {
        return new ComputerBook();
    }
}
