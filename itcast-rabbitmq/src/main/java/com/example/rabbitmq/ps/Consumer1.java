package com.example.rabbitmq.ps;

import com.example.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 10:15
 **/
public class Consumer1 {
    private final static String EXCHANGE_NAME = "test_exchange_fanout";
    private final static String QUEUE_NAME = "test_queue_ps1";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
//        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // queueName是通过queue获取的，而不是自己写死的？
        String queueName = channel.queueDeclare().getQueue();
        System.out.println("queueName=====" + queueName);
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" 前台系统收到消息：'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
