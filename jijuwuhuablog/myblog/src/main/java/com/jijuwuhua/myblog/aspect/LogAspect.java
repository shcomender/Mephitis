package com.jijuwuhua.myblog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author ：chenjiajun
 * @description：利用SpringBoot AOP进行日志处理,对指定包下的所有请求进行拦截，记录日志
 * @date ：2021/3/10 15:56
 */
//切面操作注解
@Aspect
//SpringBoot组件扫描
@Component
public class LogAspect {
    //变量声明
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
    * @Description: 定义一个切面，也就是方法
    * @Param: []
    * @return: void
    * @Author: chenjiajun
    * @Date: 2021/3/10
    */
    //指定切面拦截的范围
    @Pointcut("execution(* com.jijuwuhua.myblog.web.*.*(..))")
    public void log(){

    }

    /**
    * @Description: 方法执行前,记录
    * @Param: []
    * @return: void
    * @Author: chenjiajun
    * @Date: 2021/3/10
    */
    @Before("log()")
    public void doBefor(JoinPoint joinPoint){
        //JoinPoint对象封装了SpringAop中切面方法的信息,
        //在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取各种参数，构造日志内部类
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethond = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog= new RequestLog(url,ip,classMethond,args);

        logger.info("Request : {}",requestLog);
    }
    
    /**
    * @Description: 方法执行后执行
    * @Param: []
    * @return: void
    * @Author: chenjiajun
    * @Date: 2021/3/10
    */
    @After("log()")
    public void doAfter(){
        logger.info(("--------after------"));
    }
    
    /**
    * @Description: 执行方法返回参数后执行的操作
    * @Param: [result]
    * @return: void
    * @Author: chenjiajun
    * @Date: 2021/3/10
    */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("------Result : { }"+result);
    }

    /**
    * @Description: 记录日志参数的内类
     * 其记录的属性包括，url,ip,调用的方法，参数列表
    * @Author: chenjiajun
    * @Date: 2021/3/10
    */
    private class RequestLog{
        private String Url;
        private String Ip;
        private String ClassMethond;
        private Object args[];

        public RequestLog(String url, String ip, String classMethond, Object[] args) {
            Url = url;
            Ip = ip;
            ClassMethond = classMethond;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "Url='" + Url + '\'' +
                    ", Ip='" + Ip + '\'' +
                    ", ClassMethond='" + ClassMethond + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
