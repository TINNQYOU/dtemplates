package com.tinnkyou.bean;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wb-cq355812
 * @create 2019/05/14
 */
@Getter@Setter
public class UserAccount {
    private long id;
    private String username;
    private BigDecimal account;
}
