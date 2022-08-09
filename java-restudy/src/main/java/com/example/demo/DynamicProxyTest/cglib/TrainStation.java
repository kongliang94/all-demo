package com.example.demo.DynamicProxyTest.cglib;

/**
 *  火车站
 */
public class TrainStation {

    public void sell() {
        System.out.println("火车站卖票");
    }

    public void refund() {
        System.out.println("火车站退票");
    }
}
