package com.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDemo {
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        Jedis resource = jedisPool.getResource();
        resource.auth("123456");
        resource.set("name","chen");
        resource.multi();
        resource.close();
    }
}