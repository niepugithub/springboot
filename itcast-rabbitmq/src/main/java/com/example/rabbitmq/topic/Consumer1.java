package com.example.rabbitmq.topic;

import com.example.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 13:23
 **/
public class Consumer1 {
    private static final String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // topic模式
        channel.exchangeDeclare(EXCHANGE_NAME, ExchangeTypes.TOPIC);
        String queueName = channel.queueDeclare().getQueue();

        // consumer1的模糊匹配有：*.orange.*
        // 消费者1 订阅了主题是以orange在中间的消息
        channel.queueBind(queueName, EXCHANGE_NAME, "*.orange.*");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" consumer1收到的消息有： '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
