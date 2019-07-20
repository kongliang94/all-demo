package com.example.demo.DelayQueue;/**
 * @Classname Consumer
 * @Description TODO
 * @Date 2019/7/18 17:08
 * @Created by windows
 */

import java.util.concurrent.DelayQueue;

/**
 * @description: 消费者
 * @author: KL
 * @create: 2019-07-18
 */
public class Consumer implements Runnable {

    // 延时队列 ,消费者从其中获取消息进行消费
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message take = queue.take();
                System.out.println(" 消息体：" + take.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
