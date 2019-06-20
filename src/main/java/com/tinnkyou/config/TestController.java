package com.tinnkyou.config;

import com.tinnkyou.demo.demo2.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wb-cq355812
 * @create 2019/06/19
 */
@Controller
@RequestMapping(value = "/rootUrl")
@ApiAction(name = "/rootUrl",desc = "测试的控制类",params = {})
public class TestController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ApiAction(name = "/test",method = RequestMethod.GET,
        params = {@ApiAction.ParamsInfo(type = "int",value = "age"),
                  @ApiAction.ParamsInfo(type = "string",value = "name")})
    public String testContro(String name,String age){
        return "";
    }
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    @ApiAction(name = "/getUser",method = RequestMethod.POST,
    params = {@ApiAction.ParamsInfo(type = "json",value = "user")})
    public String getObj(User user){
        return "";
    }
}
