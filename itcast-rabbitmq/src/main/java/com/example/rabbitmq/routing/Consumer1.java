package com.example.rabbitmq.routing;

import com.example.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;


/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 12:43
 **/
public class Consumer1 {
    private static final String EXCHANGE_NAME="test_exchange_direct";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, ExchangeTypes.DIRECT);
        String queueName = channel.queueDeclare().getQueue();

        // consumer1拥有奇数的routing
        for(int i=0;i<ConnectionUtil.argv.length;i+=2){
            channel.queueBind(queueName, EXCHANGE_NAME, ConnectionUtil.argv[i]);
        }

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
