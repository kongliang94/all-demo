package com.github.rabbitmq.sender;

import com.github.rabbitmq.component.ExpirationMessagePostProcessor;
import com.github.rabbitmq.config.QueueConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 
 * @author KL
 * @date 2018年11月20日
 */
@Component
public class HelloSender {

    private static Logger logger = LoggerFactory.getLogger(HelloSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;
     
    /**
     * 
     * @author KL
     * @date 2018年11月20日
     * @description 模拟发送数据到消息队列
     * @param message  发送的信息
     * @param expiration message的失效时间
     */
	public void send(String message,Long expiration) {
		
       /* rabbitTemplate.convertAndSend(QueueConfig.DELAY_QUEUE_PER_MESSAGE_TTL_NAME,
        		(Object) (message +""+ expiration), new ExpirationMessagePostProcessor(expiration));*/
       

		//System.out.println("----"+message);
		doSomething(message, expiration);
		
        logger.info(String.format("send message: %s", message));
    }
	/**
	 * 
	 * @author KL
	 * @date 2018年11月20日
	 * @description 模拟其他线程发送数据
	 * @param object
	 * @param expiration
	 */
	public void doSomething(Object object,Long expiration){
		new Thread(new Runnable() {		
			@Override
			public void run() {
				rabbitTemplate.convertAndSend(QueueConfig.REFUND_QUEUE_PER_MESSAGE_TTL,
						object,
						new ExpirationMessagePostProcessor(expiration));
			}
		}).start();
	}
}