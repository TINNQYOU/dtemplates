package com.tinnkyou.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ApiAction(name = "/test",method = RequestMethod.GET,params = {"name","age"})
    public String testContro(String name,String age){
        System.out.println(name + " " + age);
        return "";
    }
}
