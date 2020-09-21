package com.example.demo.ThreadStudy.demo1;

import java.util.concurrent.CountDownLatch;

public class WaitNotifyTest {
    public static void main(String[] args) {
        char[] ca="123456789".toCharArray();
        char[] cb="abcdefghi".toCharArray();

        Object o=new Object();

        CountDownLatch countDownLatch=new CountDownLatch(1);

        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o){
                for (char c : ca) {
                    try {
                        System.out.print(c);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t1").start();

        new Thread(()->{
            synchronized (o){
                if (countDownLatch.getCount()!=0){
                    countDownLatch.countDown();
                }
                for (char c : cb) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t2").start();
    }
}
