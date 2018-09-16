package com.example.rabbitmq.springboot;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 16:36
 **/
@Controller
public class AutoConsumer {
    // 指定队列进行消费
    @RabbitListener(queues = "test_queue_springboot_auto")
    public void processMessage(String content) {
        System.out.println("接收到消息是content====="+content);
    }
}
