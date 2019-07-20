package com.example.demo.ThreadStudy;/**
 * @Classname DelayQueueTest
 * @Description TODO
 * @Date 2019/7/18 16:48
 * @Created by windows
 */

import org.apache.logging.log4j.message.Message;

import java.util.concurrent.*;

/**
 * @description: 延时队列测试
 * @author: KL
 * @create: 2019-07-18
 */
public class DelayQueueTest {


    public void test(){


        DelayQueue queue=new DelayQueue();
        for (int i=0;i<7;i++){
            Runnable beeper = () -> System.out.println("beep");

            //queue.add();
        }

    }
}
