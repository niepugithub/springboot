package com.example.rabbitmq.work;

import com.example.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/15 22:54
 **/
public class Produce {
    private static final String QUEUE_NAME="test_queue_work";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明或者说创建队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        for(int i=0;i<100;i++){
            String message="中国"+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes("gbk"));
            System.out.println("[x] sent '"+message+"'");
//            Thread.sleep(i*10);
        }
//        channel.close();
//        connection.close();
    }
}
