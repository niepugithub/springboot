package com.example.rabbitmq.ps;

import com.example.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 10:08
 **/
public class Produce {
    private final static String EXCHANGE_NAME="test_exchange_fanout";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        // 之前是声明队列，现在是声明交换机
        //  channel.queueDeclare(EXCHANGE_NAME,false,false,false,null);
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        String message="商品已经被更新，id=1001";
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println("后台系统："+message);
    }
}
