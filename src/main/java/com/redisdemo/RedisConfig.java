package com.redisdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    @Bean
    public JedisPool jedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMinIdle(0);
        config.setMaxTotal(100);
        config.setMaxWaitMillis(2000);
        JedisPool jedisPool = new JedisPool(config,"localhost",6379,2000,"123456");
        return jedisPool;
    }
}
