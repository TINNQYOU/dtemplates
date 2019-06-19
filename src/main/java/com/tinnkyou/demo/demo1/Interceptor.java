package com.tinnkyou.demo.demo1;

import org.apache.ibatis.plugin.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author wb-cq355812
 * @create 2019/02/18
 * 拦截器接口
 */
public interface Interceptor {
    public boolean before();
    public void after();
    public Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;
    public void afterReturning();
    public void afterThrowing();
    boolean useAround();

}
