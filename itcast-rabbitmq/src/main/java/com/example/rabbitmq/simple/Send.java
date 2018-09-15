package com.example.rabbitmq.simple;

import com.example.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
    private final static String QUEUE_NAME="test_queue";
    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中获取通道
        Channel channel = connection.createChannel();
        // 数据库中有了connection还不能操作数据库，必须要有statement，amqp中channel类似

        // 创建队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 消息内容
        String message = "hello world";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        // 关闭通道
        channel.close();
        connection.close();

    }
    
    /**
     * description: 
     * author:niepu
     * param: []
     * date: 2018-09-15 21:15:02
     * return: java.lang.String
     **/
    public static String say(){
        return "hh";
    }
}
