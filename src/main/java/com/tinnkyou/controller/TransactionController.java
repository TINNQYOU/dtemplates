package com.tinnkyou.controller;

import java.math.BigDecimal;

import com.tinnkyou.TransactionDemo.IUserAccountService;
import com.tinnkyou.bean.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wb-cq355812
 * @create 2019/02/20
 */
@Controller
@RequestMapping("/redis")
public class TransactionController {
    @Autowired
    private IUserAccountService service;
    @RequestMapping(value = "/users")
    public void save(){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("chen");
        userAccount.setAccount(new BigDecimal(444444));
        service.saveAccount(userAccount);
    }
}
