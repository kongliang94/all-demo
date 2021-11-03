package com.example.demo.ThreadStudy.threadlocal;

public class ThreadLocalTest2 {
    static class MyThread extends Thread {
        private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 3; i++) {
                threadLocal.set(i);
                threadLocal=null; //设置成null，才能垃圾回收
                //System.gc(); 如果强引用还存在，无法回收
                System.out.println(getName() + " threadLocal.get() = " + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThreadA = new MyThread();
        myThreadA.setName("ThreadA");

        MyThread myThreadB = new MyThread();
        myThreadB.setName("ThreadB");

        myThreadA.start();
        myThreadB.start();
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(99999);


        System.out.println(threadLocal.get());

        //threadLocal=null;


    }

}
