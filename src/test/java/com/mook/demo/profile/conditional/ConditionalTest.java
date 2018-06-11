package com.mook.demo.profile.conditional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: maojunkai
 * @Date: 2018/6/11 下午11:16
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConditionalBeanConfig.class)
public class ConditionalTest {
    @Autowired
    private MagicBean magicBean;

    @Test
    public void test_magicBean_not_null() {
        Assert.assertNotNull(magicBean);
    }
}
