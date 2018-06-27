package com.mook.demo.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author: maojunkai
 * @Date: 2018/6/13 上午12:13
 * @Description:
 */
@Component
@Qualifier("cold")
public class IceCream implements Dessert {
}
