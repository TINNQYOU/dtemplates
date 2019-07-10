package com.tinnkyou.controller;

import com.tinnkyou.common.ApplicationContextHelper;
import com.tinnkyou.common.JsonData;
import com.tinnkyou.exception.ParamException;
import com.tinnkyou.exception.PermissionException;
import com.tinnkyou.mapper.SysAclModuleMapper;
import com.tinnkyou.param.TestVo;
import com.tinnkyou.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Slf4j
public class TestController {
    @RequestMapping(value = "test.json")
    @ResponseBody
    public JsonData test(){
        log.info("hello");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        System.out.println(moduleMapper);
        return JsonData.success();
        //throw new PermissionException("shi bai");
    }
    @RequestMapping(value = "/validate.json")
    public String aaa(TestVo vo) throws ParamException {
        log.info("{}","jsonView");
        try {
            Map<String, String> map = BeanValidator.validateObject(vo);
            if (map !=null && map.keySet().size() >0){
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    log.info("key: {},value: {}",entry.getKey(),entry.getValue());
                }
            }
        }catch (Exception e){

        }
        return "/jsonView";
    }
}
