package com.github.rabbitmq.component;

import com.github.rabbitmq.sender.HelloSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 
 * @author KL 
 * @date  2018年2月23日
 * @description 定时器
 *
 */
//@Component
//@EnableScheduling
public class Scheduler {  
    private final Logger logger = LoggerFactory.getLogger(this.getClass());  
    
    @Autowired
    private HelloSender helloSender;
    static int i=0;
   /* @Scheduled(cron="0 0/2 * * * ?") //每分钟执行一次  
    public void statusCheck() {      
        logger.info("每秒执行一次。开始……");  
        //statusTask.healthCheck();
        helloSender.send("我是hello,2分钟发送一次",10000L);
        logger.info("每秒执行一次。结束。");  
    }*/   
 
    /*@Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次  
    public void sendMessage() {      
        logger.info("每秒执行一次。开始……"+i);  
        i++;
        //statusTask.healthCheck();
        helloSender.send("hello,我是第"+i+"个",i*5000L);
        for (int i = 0; i < 1000; i++) {
        	helloSender.send("hello,我是第"+i+"个",i*30L);
		}     
        logger.info("每秒执行一次。结束。"+i);  
    }*/
    @Scheduled(fixedRate=12000)
    public void testTasks() {      
        logger.info("每20秒执行一次。开始……");  
        i++;
        //statusTask.healthCheck();
        helloSender.send("hello,我是第"+i+"个",i*1000L);
        logger.info("每20秒执行一次。结束。");  
    }    
}  
