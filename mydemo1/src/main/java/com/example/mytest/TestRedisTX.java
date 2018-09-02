package com.example.mytest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestRedisTX {
    public static void main(String[] args) {
        Jedis jedis= new Jedis("192.168.197.129",6379);
        Transaction tx = jedis.multi();
        // 注意这里用tx设值，而不是jedis，否则报错edisDataException
        tx.set("k1","english");
        tx.set("k2","v22");
        tx.set("k3","v33");
        tx.exec();
    }
}
