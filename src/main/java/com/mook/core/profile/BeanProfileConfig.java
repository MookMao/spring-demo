package com.mook.core.profile;

import com.mook.core.Person;
import com.mook.core.autowiring.Book;
import com.mook.core.autowiring.ComputerBook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author: maojunkai
 * @Date: 2018/6/9 下午6:52
 */
@Configuration
public class BeanProfileConfig {

    @Bean
    @Profile("dev")
    public Person devPerson() {
        return new Person();
    }

    @Bean
    @Profile("prod")
    public Book prodBook() {
        return new Book();
    }

//    @Bean
//    public ComputerBook computerBook() {
//        return new ComputerBook();
//    }
}
