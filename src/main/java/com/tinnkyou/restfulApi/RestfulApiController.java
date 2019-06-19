package com.tinnkyou.restfulApi;

import org.springframework.web.bind.annotation.*;

/**
 * @author wb-cq355812
 * @create 2019/02/13
 */
@RestController
@RequestMapping(value = "/restful")
public class RestfulApiController {
    /**
     * 查询接口
     * get localhost:8081/restful/list 查询所有
     * get localhost:8081/restful/list?page=1&rows=10&keyword=today&type=2 高级查询
     * post localhost:8081/restful/list 携带参数是 以'x-www-form-urlencoded' 编码格式 这样参数才能填充到qo对象里面
     */
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public String queryInfo(@ModelAttribute QueryObject qo){
        System.out.println(qo.toString());
        return "success";
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public String putInfo(@PathVariable Long id,@ModelAttribute Info info){
        System.out.println(id);
        System.out.println(info.getName());
        return "success";
    }
}
