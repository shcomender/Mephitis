package com.jijuwuhua.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：chenjiajun
 * @description：页面控制器
 * @date ：2021/3/8 23:38
 */
@Controller
public class PageController {
    //20210316
    //在没有完善其他的实体类和数据库的情况下，无法完成数据交互，只能暂时注册一个无数据交互的页面来检测框架
    @GetMapping("/about")
    public String homepage(){
        return "about";
    }

    @GetMapping("/admin/index")
    public String adminIndex(){
        return "admin/index";
    }

    @GetMapping("/admin/blogs")
    public String blogs(){
        return "admin/blogs";
    }
    @GetMapping("/admin/test")
    public String test(){
        return "admin/test";
    }
}
