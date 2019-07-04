package com.admindemo.chapter01_seckill.mapper;

import com.admindemo.chapter01_seckill.bean.TSeckill;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TSeckillMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(TSeckill record);
    int insertSelective(TSeckill record);
    TSeckill selectByPrimaryKey(Integer id);
    int updateByPrimarySelective(TSeckill record);
    int updateByPrimary(TSeckill record);
    int updateSeckill(Map<String,Object> record);
}
