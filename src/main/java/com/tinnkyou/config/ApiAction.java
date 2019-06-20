package com.tinnkyou.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wb-cq355812
 * @create 2019/06/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface ApiAction {
    String name() default "";
    RequestMethod method() default RequestMethod.GET;
    ApiAction.ParamsInfo[] params();
    String desc() default "";

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface ParamsInfo{
        String value();
        String type();
        boolean required() default false;
        String desc() default "";
    }
}
