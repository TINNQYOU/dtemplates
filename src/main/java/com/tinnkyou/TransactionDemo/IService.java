package com.tinnkyou.TransactionDemo;

import java.math.BigDecimal;

/**
 * @author wb-cq355812
 * @create 2019/05/14
 */
public interface IService {
    void saveMoney(BigDecimal money);
    void getMoney(BigDecimal money);
}
