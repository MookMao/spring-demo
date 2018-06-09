package com.mook.demo.autowiring;

import com.mook.demo.Person;
import com.mook.demo.profile.BeanProfileConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: maojunkai
 * @Date: 2018/6/9 下午7:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanProfileConfig.class)
@ActiveProfiles("dev")
public class BeanProfileTest {
    @Autowired
    private Person person;

//    @Autowired
//    private Book book;

    @Test
    public void test() {
        Assert.assertNotNull(person);
    }
}
