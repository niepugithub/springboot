package com.example.mytest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestRedisTX {
    public static void main(String[] args) {
        System.out.println(complexTx());
    }

    public static void simpleTx(){
        Jedis jedis= new Jedis("192.168.197.129",6379);
        Transaction tx = jedis.multi();
        // 注意这里用tx设值，而不是jedis，否则报错edisDataException
        tx.set("k1","english");
        tx.set("k2","v22");
        tx.set("k3","v33");
        tx.exec();
    }

    public static boolean complexTx(){
        Jedis jedis= new Jedis("192.168.197.129",6379);
        int amtToSubtract=10;
        jedis.watch("balance");
        // 其他程序修改了balance
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int balance = Integer.parseInt(jedis.get("balance"));
        System.out.println(balance);
        if(balance<amtToSubtract){
            jedis.unwatch();
            System.out.println("==========modify by someone=========");
            return false;
        }else {
            System.out.println("=====transaction====");
            Transaction tx = jedis.multi();
            tx.decrBy("balance",amtToSubtract);

            tx.incrBy("debt",amtToSubtract);
            tx.exec();
            System.out.println("balance====="+jedis.get("balance"));
            System.out.println("debt====="+jedis.get("debt"));
            return true;
        }
    }
}
