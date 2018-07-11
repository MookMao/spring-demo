package com.mook.demo.property.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Author: maojunkai
 * @Date: 2018/6/30 下午5:24
 * @Description:
 */
@Configuration
@PropertySource("classpath:app.properties")
public class ExpressiveConfig {
    @Autowired
    Environment env;

    @Bean
    public BlankDisc disc() {
        return new BlankDisc(env.getProperty("disc.title"), env.getProperty("disc.artist"));
    }
}
