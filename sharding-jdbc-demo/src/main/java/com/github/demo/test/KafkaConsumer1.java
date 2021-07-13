package com.github.demo.test;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;
import java.util.regex.Pattern;

public class KafkaConsumer1 {
    public static void main(String[] args) {
        Map<String, Object> configs = new HashMap<>();
// 指定bootstrap.servers属性作为初始化连接Kafka的服务器。
// 如果是集群，则会基于此初始化连接发现集群中的其他服务器。
        configs.put("bootstrap.servers", "localhost:9091");
// key的反序列化器
        configs.put("key.deserializer",
                "org.apache.kafka.common.serialization.IntegerDeserializer");
// value的反序列化器
        configs.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        configs.put("group.id", "consumer.demo");
        configs.put("auto.offset.reset","earliest");
// 创建消费者对象
        KafkaConsumer<Integer, String> consumer = new KafkaConsumer<Integer,
                String>(configs);

        consumer.subscribe(Arrays.asList("first-topic"));

        while (true) {
            //不断的拉取数据
            ConsumerRecords<Integer, String> records = consumer.poll(Duration.ofMillis(100)); //100ms超时
            for (ConsumerRecord<Integer, String> record : records) {
                //该消息所在的分区号
                int partition = record.partition();
                //该消息对应的key
                Integer key = record.key();
                //该消息对应的偏移量
                long offset = record.offset();
                //该消息内容本身
                String value = record.value();
//                System.out.println("========================================");
//                System.out.println("消息头字段：" +
//                        Arrays.toString(record.headers().toArray()));
//                System.out.println("消息的key：" + record.key());
//                System.out.println("消息的偏移量：" + record.offset());
//                System.out.println("消息的分区号：" + record.partition());
//                System.out.println("消息的序列化key字节数：" +
//                        record.serializedKeySize());
//                System.out.println("消息的序列化value字节数：" +
//                        record.serializedValueSize());
//                System.out.println("消息的时间戳：" + record.timestamp());
//                System.out.println("消息的时间戳类型：" + record.timestampType());
//                System.out.println("消息的主题：" + record.topic());
//                System.out.println("消息的值：" + record.value());
                System.out.println("partition:"+partition+"\t key:"+key+"\toffset:"+offset+"\tvalue:"+value);
            }
        }

    }
}