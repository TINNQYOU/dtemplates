package com.tinnkyou.demo.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author wb-cq355812
 * @create 2019/06/13
 */
@Configuration

public class UserConfig {
    @Bean(value = "user")
    public User initUser(){
        User u = new User();
        u.setAge(12);
        return u;
    }
}
