package com.tinnkyou.demo.demo2;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wb-cq355812
 * @create 2019/02/18
 */
@Getter@Setter
public class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
