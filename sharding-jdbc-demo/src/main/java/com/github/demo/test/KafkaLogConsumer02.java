package com.github.demo.test;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

public class KafkaLogConsumer02 {
    public static void main(String[] args) {
        Properties props=new Properties();
        //kafka集群地址
        props.put("bootstrap.servers", "localhost:9091");
        //消费者组id
        props.put("group.id", "group_topic_first");
        //自动提交偏移量
        props.put("enable.auto.commit", "false");
        //默认是latest
        //earliest: 当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费
        //latest: 默认值，当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，消费新产生的该分区下的数据
        //none : topic各分区都存在已提交的offset时，从offset后开始消费；只要有一个分区不存在已提交的offset，则抛出异常
        //props.put("auto.offset.reset","earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String,String> consumer=new KafkaConsumer<String, String>(props);
        //指定消费哪些topic
        consumer.subscribe(Arrays.asList("testTopic"));
        //定义一个数字，表示消息最小达到多少后手动提交偏移量
        final int minBatchSize = 50;

        //定义一个数组，缓冲一批数据
        List<ConsumerRecord<String, String>> buffer = new ArrayList<ConsumerRecord<String, String>>();
        while (true) {
            //不断的拉取数据
            ConsumerRecords<String, String> records = consumer.poll(1000); //100ms超时
            for (ConsumerRecord<String, String> record : records) {
                //该消息所在的分区号
                int partition = record.partition();
                //该消息对应的key
                String key = record.key();
                //该消息对应的偏移量
                long offset = record.offset();
                //该消息内容本身
                String value = record.value();
                System.out.println("partition:"+partition+"\t key:"+key+"\toffset:"+offset+"\tvalue:"+value);

                //buffer.add(record);
                if (buffer.size() >= minBatchSize) {
                    //insertIntoDb(buffer);  拿到数据之后，进行消费
                    System.out.println("缓冲区的数据条数："+buffer.size());
                    System.out.println("我已经处理完这一批数据了...");
                    consumer.commitSync();  //同步手动提交偏移量

                    //consumer.commitAsync(); //异步手动提交偏移量

                  /*  consumer.commitAsync(new OffsetCommitCallback() {
                        @Override
                        public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                            if (e!=null) {
                                System.out.println(offset+" "+e.getMessage());
                            }
                        }
                    });*/

                    ////////////////同步和异步组合提交
//                    try {
//                        consumer.commitAsync();
//                    }catch (Exception e) {
//                    }finally {
//                        consumer.commitSync();
//                    }

                    /////////提交特定的偏移量/再均衡监听器/从特定偏移量处开始处理记录
                    buffer.clear();
                }
            }
        }
    }
}
