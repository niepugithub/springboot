package com.example.rabbitmq.routing;

import com.example.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.core.ExchangeTypes;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 12:43
 **/
public class Produce {
    private static final String EXCHANGE_NAME="test_exchange_direct";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, ExchangeTypes.DIRECT);

        for(String severity : ConnectionUtil.argv){
            String message = "Hello,路由模式"+severity;
            // 第二个参数severity指定routing路径
            channel.basicPublish(EXCHANGE_NAME,severity,null,message.getBytes());
        }
    }
}
