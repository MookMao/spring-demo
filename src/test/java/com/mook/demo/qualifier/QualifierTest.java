package com.mook.demo.qualifier;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: maojunkai
 * @Date: 2018/6/13 上午12:17
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class QualifierTest {

    @Autowired
    @Qualifier("cold")
    private Dessert dessert;

    @Test
    public void test() {
        Assert.assertNotNull(dessert);
    }
}
