package com.admindemo.chapter01.service;

import com.admindemo.chapter01.bean.TSeckill;
import org.springframework.stereotype.Service;

@Service
public interface ITSeckillService {
    int deleteByPrimaryKey(Integer id);
    int insert(TSeckill record);
    int insertSelective(TSeckill record);
    TSeckill selectByPrimaryKey(Integer id);
    int updateByPrimarySelective(TSeckill record);
    int updateByPrimary(TSeckill record);
    boolean updateSeckill(String sku,int buys);
}
