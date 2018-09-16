package com.example.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {


    public static String[] argv=new String[]{"error","warning","info"};
    public static String[] topic=new String[]{"","",""};

    public static Connection getConnection() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/taotao");
        factory.setUsername("taotao");
        factory.setPassword("taotao");
        Connection connection = factory.newConnection();
        return connection;
    }
}