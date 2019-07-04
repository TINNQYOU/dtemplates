package com.admindemo.chapter01_seckill.service;

import com.admindemo.chapter01_seckill.bean.TSeckill;

public interface ITSeckillService {
    int deleteByPrimaryKey(Integer id);
    int insert(TSeckill record);
    int insertSelective(TSeckill record);
    TSeckill selectByPrimaryKey(Integer id);
    int updateByPrimarySelective(TSeckill record);
    int updateByPrimary(TSeckill record);
    boolean updateSeckill(String sku,int buys);
}
