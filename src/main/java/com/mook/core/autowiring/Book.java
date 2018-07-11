package com.mook.core.autowiring;

import org.springframework.stereotype.Component;

/**
 * @Author: maojunkai
 * @Date: 2018/6/9 下午4:43
 */
@Component
public class Book {
    public void printTitle() {
        System.out.println("i am a book");
    }
}
