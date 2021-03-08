package com.jijuwuhua.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：chenjiajun
 * @description：测试控制器
 * @date ：2021/3/8 23:36
 */
@Controller
public class controller {
    /**
    * @Description: 测试框架运行
    * @Param: []
    * @return: java.lang.String
    * @Author: chenjiajun
    * @Date: 2021/3/8
    */
    @ResponseBody
    @RequestMapping("/test")
    public String Test(){
        int a = 10/0;
        return "about";
    }
}
