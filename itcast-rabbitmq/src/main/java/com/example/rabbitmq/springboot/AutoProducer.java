package com.example.rabbitmq.springboot;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 16:36
 **/
@Controller
public class AutoProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/autoSend")
    @ResponseBody
    public String autoSend(String[] message){
        // 指定队列进行消息发送
        for(String s:message){
            rabbitTemplate.convertAndSend("test_queue_springboot_auto",s);
        }
        return "message sent success";
    }
}
