package com.jijuwuhua.myblog.web;

import com.jijuwuhua.myblog.handler.InternalServerException;
import com.jijuwuhua.myblog.handler.NotFindException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//    @ResponseBody
    @GetMapping("/1")
    public String Test(){
    //@PathVariable URL中接收参数
//        try{
//            int a = 10/0;
//        }catch (Exception e){
//            throw new InternalServerException("服务器内部错误");
//        }
//        String blog = null;
//        if (blog == null)throw new NotFindException("博客不存在");
//        System.out.println("-----------");
        return "example";
    }
}
