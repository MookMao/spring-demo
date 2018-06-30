package com.mook.demo.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author: maojunkai
 * @Date: 2018/6/13 上午12:13
 * @Description: 为bean创建自定义的限定符
 */
@Component
@Qualifier("cold")
@Creamy
public class IceCream implements Dessert {
}
