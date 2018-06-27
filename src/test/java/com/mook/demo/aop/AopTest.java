package com.mook.demo.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: maojunkai
 * @Date: 2018/6/27 上午11:17
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class AopTest {
    @Resource
    private CalculateService calculateService;

    @Test
    public void test() {
        System.out.println(calculateService.add(1, 2));
    }
}
