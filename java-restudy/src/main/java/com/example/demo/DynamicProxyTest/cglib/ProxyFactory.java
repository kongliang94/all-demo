package com.example.demo.DynamicProxyTest.cglib;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {

    private TrainStation target = new TrainStation();

    public TrainStation getProxyObject() {

        Enhancer enhancer=new Enhancer();

        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(new MyMethod());
        //创建代理对象
        TrainStation obj = (TrainStation) enhancer.create();
        return obj;
    }
}
