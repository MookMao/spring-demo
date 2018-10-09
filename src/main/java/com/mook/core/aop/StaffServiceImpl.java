package com.mook.core.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: maojunkai
 * @Date: 2018/9/26 下午4:46
 * @Description:
 */
@Component
@Slf4j
public class StaffServiceImpl implements StaffService {

    @LogAnnotation
    @Override
    public String say(String message) {
        log.info("say");
        return this.getClass() + ", say";
    }

    @Override
    public String dance() {
        return this.getClass() + ", dance";
    }
}
