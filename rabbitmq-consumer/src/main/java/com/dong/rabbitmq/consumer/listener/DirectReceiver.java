package com.dong.rabbitmq.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author caishaodong
 * @Date 2020-10-26 10:54
 * @Description rabbitmq监听器
 **/
@Component
@RabbitListener(queues = "MyDirectQueue")
public class DirectReceiver {

    @RabbitHandler
    public void process(Map message) {
        System.out.println("第一个DirectReceiver消费者收到消息  : " + message.toString());
    }
}
