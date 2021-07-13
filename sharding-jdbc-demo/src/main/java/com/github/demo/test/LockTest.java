package com.github.demo.test;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    static ReentrantLock lock=new ReentrantLock();
    public static void main(String[] args) {
        LockTest lockTest=new LockTest();
        for (int i = 0; i < 50; i++) {

            new Thread(()->{

            }).start();

        }

    }

    public static int incr(Integer a){


        lock.lock();
        a++;
        lock.unlock();
        return a;
    }
}
