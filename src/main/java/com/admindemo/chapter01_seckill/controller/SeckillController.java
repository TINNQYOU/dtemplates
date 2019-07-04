package com.admindemo.chapter01_seckill.controller;

import com.admindemo.chapter01_seckill.bean.TSeckill;
import com.admindemo.chapter01_seckill.service.impl.TSeckillMysqlService;
import com.admindemo.chapter01_seckill.service.impl.TSeckillRedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 秒杀的两种方式
 * 1.使用sql来控制防止超卖
 * 2.使用redis来控制
 */
@Controller
public class SeckillController {
    private AtomicInteger goodsales = new AtomicInteger();
    private AtomicInteger accountNum = new AtomicInteger();
    private String sku = "iphone7";
    private int buy = 1;
    @Autowired
    TSeckillMysqlService itSeckillService;
    @Autowired
    TSeckillRedisServiceImpl redisService;
    @RequestMapping(value = "/seckill")
    @ResponseBody
    /**
     * 此逻辑 是使用数据库sql的更新来保证 防止超卖 详见mapper中的sql语句
     */
    public String seckill(){
        for (int i = 0; i < 300; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (itSeckillService.updateSeckill(sku,buy)){
                        accountNum.incrementAndGet();
                        goodsales.addAndGet(buy);
                        System.out.println("成功卖出了一件商品---销售量："+accountNum);

                    }else {
                        System.out.println("商品已经销售完了");
                    }
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("=====成功购买商品的顾客数量====="+goodsales);
//            System.out.println("=====卖出的商品数量============"+accountNum);
        }
        return "success";
    }
    @RequestMapping(value = "/redisSeckill")
    @ResponseBody
    public String seckillRedis(){
        TSeckill tSeckill = new TSeckill();
        tSeckill.setSku(sku);
        tSeckill.setNum(100);
        //redisService.insert(tSeckill);


        for (int i = 0; i < 300; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (redisService.updateSeckill(sku,buy)){
                        accountNum.incrementAndGet();
                        goodsales.addAndGet(buy);
                        System.out.println("成功卖出了一件商品---销售量："+accountNum);
                    }else {
                        System.out.println("商品已经销售完了");
                    }
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
