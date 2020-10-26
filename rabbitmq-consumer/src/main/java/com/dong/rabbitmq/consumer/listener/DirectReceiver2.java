package com.dong.rabbitmq.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author caishaodong
 * @Date 2020-10-26 10:54
 * @Description rabbitmq监听器
 * 配置2个直连交换机
 * 测试结论：
 * 第一个DirectReceiver消费者收到消息  : {createTime=2020-10-26 11:02:11, messageId=6515754a-9124-49b6-973f-3e8655099e1b, messageData=test message, hello!}
 * 第二个DirectReceiver消费者收到消息  : {createTime=2020-10-26 11:02:13, messageId=0ccc622a-f9d8-4290-aaf7-b13cb4f70fb1, messageData=test message, hello!}
 * 第一个DirectReceiver消费者收到消息  : {createTime=2020-10-26 11:02:14, messageId=e5908bf9-92df-40df-911a-9b69457102cd, messageData=test message, hello!}
 * 第二个DirectReceiver消费者收到消息  : {createTime=2020-10-26 11:02:15, messageId=5cec0ed8-f8fe-4d4d-bef4-9d3daed7f8ed, messageData=test message, hello!}
 * 两个交换机会轮训消费消息，而且不会重复消费
 **/
@Component
@RabbitListener(queues = "MyDirectQueue")
public class DirectReceiver2 {

    @RabbitHandler
    public void process(Map message) {
        System.out.println("第二个DirectReceiver消费者收到消息  : " + message.toString());
    }
}
