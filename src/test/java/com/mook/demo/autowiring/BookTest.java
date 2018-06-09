package com.mook.demo.autowiring;

import com.mook.demo.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: maojunkai
 * @Date: 2018/6/9 下午4:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {BeanConfig.class, JavaBeanConfig.class})
@ContextConfiguration(classes = RootConfig.class)
public class BookTest {
    @Autowired
    private Book book;

    @Autowired
    private ComputerBook computerBook;

    @Autowired
    private Person person;

    @Test
    public void bookTest() {
        Assert.assertNotNull(book);
        book.printTitle();
    }

    @Test
    public void computerBookTest() {
        Assert.assertNotNull(computerBook);
        computerBook.printTitle();
    }

    @Test
    public void personTest() {
        Assert.assertNotNull(person);
        System.out.println(person.getClass().getName());
    }
}
