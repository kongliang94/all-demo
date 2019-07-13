package com.example.demo.ThreadStudy;

public class MultipleThreadsExample {

    public static void main(String[] args) {
       /* NewThread t1 = new NewThread();
        t1.setName("MyThread-1");
        NewThread t2 = new NewThread();
        t2.setName("MyThread-2");
        t1.start();
        t2.start();*/

        int i=0;
        while (i<5){
            Thread thread=new Thread(new NewThread1());
            thread.setName("MyThread-"+i);
            thread.start();
            i++;
        }
    }
}
