package com.tinnkyou.demo.demo1;

import org.apache.ibatis.plugin.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author wb-cq355812
 * @create 2019/02/18
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("=====> before");
        return true;
    }

    @Override
    public void after() {
        System.out.println("=====> after");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("=====> aroundBefore.....");
        Object proceed = invocation.proceed();
        System.out.println("=====> aroundAfter.....");
        return proceed;
    }

    @Override
    public void afterReturning() {
        System.out.println("=====> afterReturning");
    }

    @Override
    public void afterThrowing() {
        System.out.println("=====> afterThrowing");
    }

    @Override
    public boolean useAround() {
        return false;
    }
}
