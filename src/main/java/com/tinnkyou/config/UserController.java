package com.tinnkyou.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wb-cq355812
 * @create 2019/06/20
 */
@Controller
@RequestMapping(value = "/rootUser")
@ApiAction(name = "/rootUser",desc = "用户类的控制类",params = {})
public class UserController {
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ApiAction(name = "/getUser",method = RequestMethod.GET,params = {},desc = "获取用户信息")
    public String getUsers(){
        return "";
    }
}
