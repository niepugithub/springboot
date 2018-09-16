package com.example.rabbitmq.topic;

import com.example.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.core.ExchangeTypes;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 13:23
 **/
public class Produce {
    private static final String EXCHANGE_NAME="test_exchange_topic";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // topic模式
        channel.exchangeDeclare(EXCHANGE_NAME, ExchangeTypes.TOPIC);

        for(String routingKey : ConnectionUtil.topic){
            String message = "Hello,topic模式"+routingKey;
            // 第二个参数severity指定routing路径;routing路径如果有通配符，则是topic模式
            channel.basicPublish(EXCHANGE_NAME,routingKey,null,message.getBytes());
        }
    }
}