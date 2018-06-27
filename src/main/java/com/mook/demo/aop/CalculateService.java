package com.mook.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: maojunkai
 * @Date: 2018/6/27 上午11:15
 * @Description:
 */
@Service
@Slf4j
public class CalculateService {

    @LogAnnotation
    public int add(int a, int b) {
        log.info("add");
        return a + b;
    }
}
