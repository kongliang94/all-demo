package com.example.demo.DynamicProxyTest.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethod implements MethodInterceptor {
    /*
        intercept方法参数说明：
            o ： 代理对象
            method ： 真实对象中的方法的Method实例
            args ： 实际参数
            methodProxy ：代理对象中的方法的method实例
     */
    @Override
    public TrainStation  intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 增强
        if (method.getName().equals("sell")){
            System.out.println("代理点收取一些服务费用(CGLIB动态代理方式)");
        }


        TrainStation result = (TrainStation) methodProxy.invokeSuper(o, args);
        return result;
    }
}
