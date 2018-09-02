package com.example.controller;

import redis.clients.jedis.Jedis;

public class RedisController {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.197.129",6379);
        System.out.println("jedis========="+jedis);
        jedis.set("jedis","第一个jedis值");
        System.out.println(jedis.get("k1"));
        System.out.println(jedis.keys("*"));
    }
}
