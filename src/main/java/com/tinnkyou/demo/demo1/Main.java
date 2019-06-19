package com.tinnkyou.demo.demo1;

/**
 * @author wb-cq355812
 * @create 2019/02/18
 */
public class Main {
    public static void main(String[] args) {
        IHelloService helloService = new HelloServiceImpl();
        IHelloService service = (IHelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        service.eat("chenqiang");
    }
}
