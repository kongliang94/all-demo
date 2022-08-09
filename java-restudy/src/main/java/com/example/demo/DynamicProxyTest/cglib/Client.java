package com.example.demo.DynamicProxyTest.cglib;

public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory=new ProxyFactory();

        TrainStation proxyObject = proxyFactory.getProxyObject();


        //proxyObject.refund();
        proxyObject.sell();
    }
}
