package com.admindemo.chapter01_seckill.service.impl;

import com.admindemo.chapter01_seckill.bean.TSeckill;
import com.admindemo.chapter01_seckill.service.ITSeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class TSeckillRedisServiceImpl implements ITSeckillService {

    @Autowired
    JedisPool jedisPool;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(TSeckill record) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(record.getSku(),String.valueOf(record.getNum()));
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return 0;
    }

    @Override
    public int insertSelective(TSeckill record) {
        return 0;
    }

    @Override
    public TSeckill selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimarySelective(TSeckill record) {
        return 0;
    }

    @Override
    public int updateByPrimary(TSeckill record) {
        return 0;
    }

    @Override
    public boolean updateSeckill(String sku, int buys) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            int num = Integer.parseInt(jedis.get(sku));
            System.out.println("------------> :"+num);
            if (num < buys){
                return false;
            }
            return jedis.decrBy(sku,buys) >= 0L;
        }finally {
            if (jedis != null){
                jedis.close();
            }

        }
    }
}
