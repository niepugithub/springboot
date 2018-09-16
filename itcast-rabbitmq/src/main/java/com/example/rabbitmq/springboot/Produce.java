package com.example.rabbitmq.springboot;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 15:18
 **/

// 使用springboot的rabbitmq模板类操作消息队列
@Controller
public class Produce {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private AmqpAdmin amqpAdmin;

    @RequestMapping("/send")
    @ResponseBody
    public String send(String[] message){
        for(String s:message){
            rabbitTemplate.convertAndSend("test_queue_springboot",s);
        }
        return "message sent success";
    }
}
