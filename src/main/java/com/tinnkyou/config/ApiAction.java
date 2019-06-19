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
@Target(ElementType.METHOD)
public @interface ApiAction {
    String name() default "";
    RequestMethod method() default RequestMethod.GET;
    String params()[];
}
