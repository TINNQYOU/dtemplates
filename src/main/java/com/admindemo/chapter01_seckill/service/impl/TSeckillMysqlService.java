package com.admindemo.chapter01_seckill.service.impl;

import com.admindemo.chapter01_seckill.bean.TSeckill;
import com.admindemo.chapter01_seckill.mapper.TSeckillMapper;
import com.admindemo.chapter01_seckill.service.ITSeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TSeckillMysqlService implements ITSeckillService {
    @Autowired
    TSeckillMapper tSeckillMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(TSeckill record) {
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
        Map<String,Object> map = new HashMap<>();
        map.put("sku",sku);
        map.put("buys",buys);
        return tSeckillMapper.updateSeckill(map) == 1;
    }


}
