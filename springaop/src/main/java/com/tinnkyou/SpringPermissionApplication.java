package com.tinnkyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tinnkyou.mapper")
public class SpringPermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPermissionApplication.class, args);
    }

}
