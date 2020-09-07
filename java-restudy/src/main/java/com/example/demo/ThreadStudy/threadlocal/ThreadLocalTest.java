package com.example.demo.ThreadStudy.threadlocal;

/**
 * @description: threadlocal
 * @author: KL
 * @create: 2020-03-30
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        new Thread(() -> {
            Message msg = new Message();
            msg.setNote("你好啊");
            MyUtil.set(msg);
            MyUtil2.set(new Thread(() -> {
                System.out.println("我是用户A设置的threadlocal内部的线程");
            }));
            new MessageConsumer().print();
        }, "用户A").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setNote("Hello");
            MyUtil.set(msg);
            MyUtil2.set(new Thread(() -> {
                System.out.println("我是用户B设置的threadlocal内部的线程");
            }));
            new MessageConsumer().print();
        }, "用户B").start();
    }
}

class Message{
    private String note;
    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }
}
class MessageConsumer{
    public void print(){
        System.out.println(Thread.currentThread().getName() + "..." + MyUtil.get().getNote());
        MyUtil2.get().start();
    }
}
class MyUtil{
    public static ThreadLocal<Message> threadlocal = new ThreadLocal<>();
    public static void set(Message msg){
        threadlocal.set(msg);
    }
    public static Message get(){
        return threadlocal.get();
    }
}

class MyUtil2{
    public static ThreadLocal<Thread> threadlocal = new ThreadLocal<>();
    public static void set(Thread msg){
        threadlocal.set(msg);
    }
    public static Thread get(){
        return threadlocal.get();
    }
}
