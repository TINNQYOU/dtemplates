package com.tinnkyou.common;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {
    private static final String START_TIME = "requestStartTime";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        log.info("request start. url:{},param:{}",url, JSON.toJSONString(parameterMap));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String url = request.getRequestURL().toString();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        Long start = (Long)request.getAttribute(START_TIME);
//        Long end   = System.currentTimeMillis();
//        log.info("request finished,costTime:{}ms, url:{},param:{}",end-start,url, JSON.toJSONString(parameterMap));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURL().toString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Long start = (Long)request.getAttribute(START_TIME);
        Long end   = System.currentTimeMillis();
        log.info("request complete,costTime:{}ms, url:{},param:{}",end-start,url, JSON.toJSONString(parameterMap));
    }
}
