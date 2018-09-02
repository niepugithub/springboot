package com.example.mytest;

import redis.clients.jedis.Jedis;

public class TestRedisMS {
    public static void main(String[] args) {
        Jedis jedis_m = new Jedis("192.168.197.129",6380);
        // System.out.println(jedis_m.ping()); // 判断是否能够连接上 pong表示连接上
        // System.out.println(jedis_m.isConnected());
        jedis_m.set("k1","总算成功了");
        Jedis jedis_s = new Jedis("192.168.197.129",6381);
//        jedis_s.slaveof("192.168.197.129",6380);
        System.out.println(jedis_s.get("k1"));
    }
}
