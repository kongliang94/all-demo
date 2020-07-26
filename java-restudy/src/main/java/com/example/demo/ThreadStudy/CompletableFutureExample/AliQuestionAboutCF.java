package com.example.demo.ThreadStudy.CompletableFutureExample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 问题描述：有多个任务并行执行，当其中一个任务出现error则执行完的回滚，未执行完的任务全部取消
 *
 * 此代码属于cpu密集型模拟方式
 */
public class AliQuestionAboutCF {

    enum Result{
        SUCCESS,FAIL,CANCEL
    }

    static List<MyTask> tasks=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 7; i++) {
            MyTask task=new MyTask("task"+i,(i+1)*50,i!=1?Result.SUCCESS:Result.FAIL);

            tasks.add(task);

            CompletableFuture f=CompletableFuture
                    .supplyAsync(()->task.runTask())
                    .thenAccept(((result)->callback(result,task)));


        }

        System.in.read();
    }

    private static void callback(Result result,MyTask task){
        if (Result.FAIL==result){
            tasks.stream()
                    .filter(task1 -> !task1.name.equals(task.getName()))
                    .forEach(task1 -> task1.cancel());
        }
    }

    private static class MyTask{

        private String name;
        private int timeInSeconds;
        private Result ret;

        volatile boolean canceling=false;
        volatile boolean canceled=false;

        public MyTask(String name, int timeInSeconds, Result ret) {
            this.name = name;
            this.timeInSeconds = timeInSeconds;
            this.ret = ret;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTimeInSeconds() {
            return timeInSeconds;
        }

        public void setTimeInSeconds(int timeInSeconds) {
            this.timeInSeconds = timeInSeconds;
        }

        public Result getRet() {
            return ret;
        }

        public void setRet(Result ret) {
            this.ret = ret;
        }

        public Result runTask(){
            int interval=100;
            int total = 0;
            try {
                for (;;){
                    Thread.sleep(interval);
                    total+=interval;
                    if (total>=timeInSeconds) break;
                    if (canceled)
                    {
                        System.out.println(name+"inter end");
                        return Result.CANCEL;
                    }
                }
            }catch (InterruptedException e){
               e.printStackTrace();
            }
            System.out.println(name+" end");

            return ret;
        }

        public void cancel(){
            if (!canceled){
                synchronized (this){
                    if (canceled) {
                        System.out.println(name +"hhhhhhhhhhhhhh");
                        return;
                    }
                    canceling=true;
                    System.out.println(name+"canceling");
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(name+"canceled");
                    canceled=true;
                }
            }
        }
    }
}
