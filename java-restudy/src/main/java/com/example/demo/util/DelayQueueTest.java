package com.example.demo.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


public class DelayQueueTest {
    private static DelayQueue delayQueue  = new DelayQueue();
    public static void main(String[] args) throws InterruptedException {

       /* new Thread(new Runnable() {
            @Override
            public void run() {

                delayQueue.offer(new MyDelayedTask("task1",0));
                delayQueue.offer(new MyDelayedTask("task2",900));
                delayQueue.offer(new MyDelayedTask("task3",100));

            }
        }).start();

        while (true) {
            Delayed take = delayQueue.take();
            System.out.println(take);

            if (delayQueue.size()==0){
                break;
            }
        }
*/

       System.out.println("start");
        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("4000退出");
                this.cancel();
            }
        }, 4000);// 这里百毫秒
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("1500退出");
                this.cancel();
            }
        }, 1500);// 这里百毫秒


        Thread.sleep(4500);
        timer.cancel();
    }
}

/**
 *  compareTo 方法必须提供与 getDelay 方法一致的排序
 */
class MyDelayedTask implements Delayed{

    private String name ;
    private long start = System.currentTimeMillis();
    private long time ;

    public MyDelayedTask(String name,long time) {
        this.name = name;
        this.time = time;
    }

    /**
     * 需要实现的接口，获得延迟时间   用过期时间-当前时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((start+time) - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    /**
     * 用于延迟队列内部比较排序   当前时间的延迟时间 - 比较对象的延迟时间
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        MyDelayedTask o1 = (MyDelayedTask) o;
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "MyDelayedTask{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    public String kk(){
        return "kl";
    }

}

