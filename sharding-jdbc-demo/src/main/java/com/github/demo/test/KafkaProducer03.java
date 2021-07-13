package com.github.demo.test;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class KafkaProducer03 {

    public static void main(String[] args) throws InterruptedException,
            ExecutionException, TimeoutException {
        Map<String, Object> configs = new HashMap<>();
        // 设置连接Kafka的初始连接用到的服务器地址
        // 如果是集群，则可以通过此初始连接发现集群中的其他broker
        configs.put("bootstrap.servers", "localhost:9091");
        // 设置key的序列化器
        configs.put("key.serializer",
                "org.apache.kafka.common.serialization.IntegerSerializer");
        // 设置value的序列化器
        configs.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        configs.put("acks", "1");
        KafkaProducer<Integer, String> producer = new KafkaProducer<Integer,
                String>(configs);
        // 用于封装Producer的消息
        for (int i = 50000; i < 100000; i++) {
            ProducerRecord<Integer, String> record = new
                    ProducerRecord<Integer, String>(
                    "first-topic",
                    i,
                    "lagou message " + i
            );
// 使用回调异步等待消息的确认
            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    System.out.println(
                            "主题：" + metadata.topic() + "\n"
                                    + "分区：" + metadata.partition() + "\n"
                                    + "偏移量：" + metadata.offset() + "\n"
                                    + "序列化的key字节：" +
                                    metadata.serializedKeySize() + "\n"
                                    + "序列化的value字节：" +
                                    metadata.serializedValueSize() + "\n"
                                    + "时间戳：" + metadata.timestamp()
                    );
                } else {
                    System.out.println("有异常：" +
                            exception.getMessage());
                }
            });
        }

        // 关闭生产者
        producer.close();

    }
}
