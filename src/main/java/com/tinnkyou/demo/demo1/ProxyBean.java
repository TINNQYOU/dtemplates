package com.tinnkyou.demo.demo1;

import org.apache.ibatis.plugin.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wb-cq355812
 * @create 2019/02/18
 */
public class ProxyBean implements InvocationHandler {
    private Object target = null;
    private Interceptor interceptor = null;

    public static Object getProxyBean(Object target,Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;
        Class<?>[] interfaces = target.getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),proxyBean);
        return proxy;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        for (Object arg : args) {
            System.out.println(arg.getClass());
        }
        //异常标识
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target,method,args);
        Object obj = null;
        try {
            if (this.interceptor.before()){
                obj = this.interceptor.around(invocation);
            }else {
                obj = method.invoke(target,args);
            }
        }catch (Exception e){
            //产生异常
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag){
            this.interceptor.afterThrowing();
        }else {
            this.interceptor.afterReturning();
            return obj;
        }
        return null;
    }

}
