package com.example.rabbitmq;

import com.example.rabbitmq.springboot.AutoProducer;
import com.example.rabbitmq.springboot.Produce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/9/16 15:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbit {

    @Autowired
    private Produce produce;

    @Test
    public void testSend(){
        String[] message=new String[]{"hello","world","你好","中国"};
        produce.send(message);
    }


    @Autowired
    private AutoProducer autoProducer;

    @Test
    public void testAutoSend(){
        String[] message=new String[]{"hello","world","你好","中国"};
        autoProducer.autoSend(message);
    }
}
