package com.tinnkyou.demo.demo3;

/**
 * @author wb-cq355812
 * @create 2019/05/15
 */
public class App {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(myThread,i+"");
            thread.start();

        }
    }
}
