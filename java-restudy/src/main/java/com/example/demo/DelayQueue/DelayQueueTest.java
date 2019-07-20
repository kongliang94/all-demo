package com.example.demo.DelayQueue;/**
 * @Classname DelayQueueTest
 * @Description TODO
 * @Date 2019/7/18 17:10
 * @Created by windows
 */

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 测试
 * @author: KL
 * @create: 2019-07-18
 */
public class DelayQueueTest {

    public static void main(String[] args) {
        // 创建延时队列
        DelayQueue<Message> queue = new DelayQueue<Message>();
        for (int i=0;i<7;i++) {
            // 添加延时消息,m1 延时3s
            Message m = new Message("world", 3000*i);
            //将延时消息放到延时队列中
            queue.offer(m);
        }

        // 启动消费线程 消费添加到延时队列中的消息，前提是任务到了延期时间
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(new Consumer(queue));
        exec.shutdown();
    }
}
