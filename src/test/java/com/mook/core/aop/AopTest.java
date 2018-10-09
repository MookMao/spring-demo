package com.mook.core.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Resource
    private StaffService staffService;

    @Test
    public void test() {
        System.out.println(calculateService.add(1, 2));
//        System.out.println(calculateService.getClass());
//        System.out.println(staffService.say("aop"));
//        System.out.println(staffService.getClass());
//        System.out.println(staffService.dance());
//        System.out.println(staffService.getClass());
    }
}
