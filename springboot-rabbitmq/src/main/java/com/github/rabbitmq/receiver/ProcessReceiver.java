package com.github.rabbitmq.receiver;

import com.github.rabbitmq.config.QueueConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author KL
 * @date 2018年11月20日
 * 
 * rabbitmq的ack机制很简单,继承接口ChannelAwareMessageListener,重写onMessage ,
 * Channel channel为一个控制ack的变量， channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true)来告知mq重新发送。
 */
//@Component
public class ProcessReceiver implements ChannelAwareMessageListener {
    public static CountDownLatch latch;
    private static Logger logger = LoggerFactory.getLogger(ProcessReceiver.class);

    public static final String FAIL_MESSAGE = "This message will fail";

    static int i=0;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
    	System.out.println("consumer--:"+message.getMessageProperties()+":"+new String(message.getBody()));
        try {
        	//手动进行应答
        	channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        	
            processMessage(message);
        }
        catch (Exception e) {
            // 如果发生了异常，则将该消息重定向到缓冲队列，会在一定延迟之后自动重做
            channel.basicPublish(QueueConfig.PER_QUEUE_TTL_EXCHANGE_NAME, QueueConfig.DELAY_QUEUE_PER_QUEUE_TTL_NAME, null,
                    "The failed message will auto retry after a certain delay".getBytes());
        }

        if (latch != null) {
            latch.countDown();
        }
    }

    /**
     * 模拟消息处理。如果当消息内容为FAIL_MESSAGE的话，则需要抛出异常
     *
     * @param message
     * @throws Exception
     */
    public void processMessage(Message message) throws Exception {
    	
        String realMessage = new String(message.getBody());
        //System.out.println(realMessage);
        if (realMessage.contains("delay_queue_per_message_ttl")) {
        	logger.info("Received <" + realMessage + ">");
		}else if(realMessage.contains("hello")){
			logger.info("接收到hello的信息： <" + realMessage + ">");
			/*rabbitTemplate.convertAndSend(QueueConfig.DELAY_QUEUE_PER_MESSAGE_TTL_NAME, 
					(Object)(" unique one"),
					new ExpirationMessagePostProcessor(6000L));*/
		}else if (realMessage.contains("unique")) {
			i++;
			logger.info("接收到unique的信息： <" + realMessage + i+">");
		}
        
        if (Objects.equals(realMessage, FAIL_MESSAGE)) {
            throw new Exception("Some exception happened");
        }
    }
}
