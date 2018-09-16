package com.example.rabbitmq.springboot;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 15:27
 **/
@Component
public class consumer1 {

    @RabbitListener(queues = "test_queue_springboot")
    public void processMessage(String content) {
        System.out.println("接收到消息是content====="+content);
    }
}
