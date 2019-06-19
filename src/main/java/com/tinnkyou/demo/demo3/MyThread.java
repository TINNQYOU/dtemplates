package com.tinnkyou.demo.demo3;

/**
 * @author wb-cq355812
 * @create 2019/05/15
 */
public class MyThread extends Thread {
    int count= 100;
    @Override
    public void run() {
        while (count > 0){
            System.out.println(Thread.currentThread().getName() + "===>count : "+count);
            count --;
        }

    }
}
