package com.example.demo.ThreadStudy;

public class SingleThreadExample {
    public static void main(String[] args) {
        //普通继承Thread
        NewThread t = new NewThread();
        t.start();

        //普通传递Runnable,因为@FunctionalInterface
        new Thread(()->{
            System.out.println("1");
        }).start();
        //实现Runnable
        new Thread(new NewThread1()).start();
    }
}
