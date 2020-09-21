package com.example.demo.ThreadStudy.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 俩个线程交替打印
 */
public class LockConditionTest {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition condition1=lock.newCondition();
        Condition condition2=lock.newCondition();

        char[] ca="123456789".toCharArray();
        char[] cb="abcdefghi".toCharArray();



        new Thread(()->{

            try {
                lock.lock();
                for (char c : ca) {
                    try {
                        System.out.print(c);
                        condition2.signal();
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition1.signal();
            } finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            lock.lock();
            try{
                for (char c : cb) {
                    System.out.print(c);
                    try {
                        condition1.signal();
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition2.signal();
            } finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
