package com.github.rabbitmq.receiver;

import com.github.rabbitmq.config.QueueConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class HandleReceiver {

	private static Logger logger = LoggerFactory.getLogger(ProcessReceiver.class);

	@RabbitListener(queues = QueueConfig.DELAY_PROCESS_QUEUE_NAME)
	public void handleMessage(Message message, Channel channel) throws Exception{
		try {
			logger.info(" handleMessage 监听的消息:{}", new String(message.getBody()));
			//手动应答
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
		catch (Exception e) {
			// 如果发生了异常，则将该消息重定向到缓冲队列，会在一定延迟之后自动重做
			channel.basicPublish(QueueConfig.PER_QUEUE_TTL_EXCHANGE_NAME, QueueConfig.DELAY_QUEUE_PER_QUEUE_TTL_NAME, null,
					message.getBody());
		}
	}
}
