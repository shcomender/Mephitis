package com.jijuwuhua.myblog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：chenjiajun
 * @description：统一的异常拦截逻辑处理判断
 * @date ：2021/3/8 23:40
 */
@ControllerAdvice
//加上这个注解会拦截所有带有Controller的类
public class ControllerExceptionHandler {

    //获取日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    //此处注解表示该方法可以做异常处理来用
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        //记录异常信息,控制台输出
        logger.error("Request URL : {}, Exception : {}",request.getRequestURL(),e);

        //这里判断这个异常有没有指定状态，指定了就交给Springboot处理，没有指定就返回到错误页面
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }

        //创建mv对象
        ModelAndView mv = new ModelAndView();
        //向页面传参准备
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        //返回的页面的目录
        mv.setViewName("error/error");
        return mv;
    }
}
