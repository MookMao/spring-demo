package com.mook.demo.autowiring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: maojunkai
 * @Date: 2018/6/9 下午5:03
 */
@Configuration
@Import({
        BeanConfig.class,
        JavaBeanConfig.class
})
@ImportResource("config-spring.xml")
public class RootConfig {
}
