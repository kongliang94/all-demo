package com.example.demo.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {
        if(connect()){
            Timer timer = new Timer();// 实例化Timer类
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println(2000);
                }
            }, 2000);// 这里百毫秒

            //还可以在更新锁设备的key
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println(3000);
                }
            }, 2500);// 这里百毫秒
            try {
                Thread.sleep(3000);  //需要sleep,不然timer会直接cancel
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer.cancel();
        }

    }

    public static Boolean connect(){

        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println(500);
            }
        }, 500);// 这里百毫秒

        try {
            Thread.sleep(500);  //需要sleep,不然timer会直接cancel
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();

        return true;
    }
}
