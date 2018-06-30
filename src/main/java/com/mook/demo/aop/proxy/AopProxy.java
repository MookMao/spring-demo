package com.mook.demo.aop.proxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: maojunkai
 * @Date: 2018/6/28 下午5:35
 * @Description:
 * 在spring框架中，动态代理的策略: 如果被拦截的方法，是接口中定义的方法，以jdk动态代理生成代理对象，实现通知；
 * 否则，使用cglib进行生成子类代理实例，实现通知；
 * 事实上，无论是否在接口中定义的方法，均可使用cglib生成动态代理对象，完成拦截和通知，是更通用的方式；
 * 但由于jdk动态代理的性能更佳，因此spring框架中优先选择jdk动态代理技术。
 *
 * spring实现aop，动态代理技术的两种实现是jdk动态代理、cglib代理，根据被通知的方法是否为接口方法，来选择使用哪种代理生成策略
 * jdk动态代理，原理是实现接口的实例，拦截定义于接口中的目标方法，性能更优，是spring生成代理的优先选择
 * cglib代理，原理是使用cglib库中的字节码动态生成技术，生成被代理类的子类实例，可以拦截代理类中的任一public方法的调用，无论目标方法是否定义于接口中，更通用，但性能相对jdk代理差一些
 */
public class AopProxy {

    public static Object createProxyByJdkDynamicProxy(final Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass()
                .getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before(proxy, method, args);
                Object ret = method.invoke(target, args);
                after(proxy, method, args);
                return ret;
            }
        });
    }

    public static <T> T createProxyByCglib(final T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(AopProxy.class.getClassLoader());
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new org.springframework.cglib.proxy.InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before(proxy, method, args);
                Object ret = method.invoke(target, args);
                after(proxy, method, args);
                return ret;
            }
        });
        return (T)enhancer.create();
    }

    private static void before(Object proxy, Method method, Object[] args) {
        System.out.println("do something before: " + method.getName());
    }

    private static void after(Object proxy, Method method, Object[] args) {
        System.out.println("do something after: " + method.getName());
    }

    public static void main(String[] args) {
        ITarget t = new TargetImpl();
        /**
         * 利用jdk的动态代理技术，对TargetImpl#sayHello()进行代理，生成的代理对象是ITarget接口的一个实例
         * 其只有sayHello()接口是可见的，因此也只能拦截sayHello()
         */
        ITarget proxy = (ITarget) createProxyByJdkDynamicProxy(t);
        proxy.sayHello();
        // proxy.sayHello2();

        /**
         * 利用cglib库，对TargetImpl的两个方法均可进行代理，无论是否是接口中定义的方法
         */
        TargetImpl cglibProxy = (TargetImpl) createProxyByCglib(t);
        cglibProxy.sayHello();
        cglibProxy.sayHello2();
    }

}

interface ITarget {
    void sayHello();
}

class TargetImpl implements ITarget {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    public void sayHello2() {
        System.out.println("hello 2!");
    }
}
