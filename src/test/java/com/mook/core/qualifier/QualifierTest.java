package com.mook.core.qualifier;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
    @Creamy
    private Dessert dessert;

    @Test
    public void test() {
        Assert.assertNotNull(dessert);
        System.out.println(dessert.getClass().getName());
    }

    /**
     * @Resource 注解默认先按照名称匹配bean，此时容器中是存在一个名称为cake的bean的，所以执行成功。
     */
    /**
    @Resource
    private Dessert cake;

    @Test
    public void test() {
        Assert.assertNotNull(cake);
    }
    */
}
