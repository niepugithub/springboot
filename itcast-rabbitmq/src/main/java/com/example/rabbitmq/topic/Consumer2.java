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
public class Consumer2 {
    private static final String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // topic模式
        channel.exchangeDeclare(EXCHANGE_NAME, ExchangeTypes.TOPIC);
        String queueName = channel.queueDeclare().getQueue();

        // consumer2的模糊匹配有：*.*.rabbit,lazy.#
        // 消费者订阅了rabbit，和lazy主题的消息
        channel.queueBind(queueName, EXCHANGE_NAME, "*.*.rabbit");
        channel.queueBind(queueName, EXCHANGE_NAME, "lazy.#");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" consumer2收到的消息有： '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
