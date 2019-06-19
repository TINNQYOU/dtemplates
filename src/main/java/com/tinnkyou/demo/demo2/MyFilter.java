package com.tinnkyou.demo.demo2;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

/**
 * @author wb-cq355812
 * @create 2019/06/13
 */

public class MyFilter implements Filter {
    @Override
    public FilterType type() {
        return null;
    }

    @Override
    public Class<?>[] value() {
        return new Class[0];
    }

    @Override
    public Class<?>[] classes() {
        return new Class[0];
    }

    @Override
    public String[] pattern() {
        return new String[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
