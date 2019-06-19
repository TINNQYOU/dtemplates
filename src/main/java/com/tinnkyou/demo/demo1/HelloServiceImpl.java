package com.tinnkyou.demo.demo1;

/**
 * @author wb-cq355812
 * @create 2019/02/18
 */
public class HelloServiceImpl implements IHelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || "".equals(name.trim())){
            throw new RuntimeException("parameter is null !!");
        }
        System.out.println("hello "+name);
    }

    @Override
    public void eat(String name) {
        System.out.println("正在吃 "+ name);
    }
}
