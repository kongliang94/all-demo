package com.example.demo.ThreadStudy;

public class NewThread1 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程-"+Thread.currentThread().getName());
    }
}
