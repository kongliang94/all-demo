package com.example.demo.DelayQueue;/**
 * @Classname Message
 * @Description TODO
 * @Date 2019/7/18 17:04
 * @Created by windows
 */

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @description: 延时信息
 * @author: KL
 * @create: 2019-07-18
 */
public class Message implements Delayed {

    private String body; // 消息内容
    private long excuteTime;

    public Message(String body,long delayTime) {
        this.body=body;
        this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Message msg = (Message) o;
        return this.excuteTime > msg.excuteTime ? 1
                : (this.excuteTime < msg.excuteTime ? -1 : 0);
    }

    public String getBody() {
        return body;
    }
}
