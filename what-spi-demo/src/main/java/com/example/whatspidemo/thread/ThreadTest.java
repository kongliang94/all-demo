package com.example.whatspidemo.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


public class ThreadTest {
    public static ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    static{
        //如果池中的实际线程数小于1，无论是否其中有空闲的线程,都会给新的任务产生新的线程
        taskExecutor.setCorePoolSize(10);
        //如果提交的线程数大于corePoolSize并且小于maxPoolSize，只会创建corePoolSize的线程数被创建，然后将任务提交到队列中，直到队列慢为止
        taskExecutor.setMaxPoolSize(30);
        taskExecutor.initialize();
    }

    public static void addTask(Runnable task) {
        taskExecutor.execute(task);
    }

    public static void shutdown() {
        try{
            taskExecutor.shutdown();
        }catch(Exception ex) {

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000000; i++) {
            addTask(new DSThread(new User(i+"","kk"+i,i)));
        }
    }

}



class DSThread implements Runnable{

    User user=new User();

    public DSThread(User user){
        this.user.setName(user.getName());
    }

    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(user.name);
    }
}

class User {
    String id;
    String name;
    int age;
    String id1="1212";
    String name1="1212";
    String id2="1212";
    String name2="1212";
    String id3="1212";
    String name3="1212";

    public User() {

    }

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}