package com.jijuwuhua.myblog.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：chenjiajun
 * @description：Web配置类/登录拦截器配置
 * @date ：2021/3/20 16:40
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加一个拦截器
        registry.addInterceptor(loginInterceptor)
                //要拦截的路径
                .addPathPatterns("/admin/**")
                //要排除的路径
                //排除登录映射
                .excludePathPatterns("/admin/login")
                //排除登录页面
                .excludePathPatterns("/admin")

                //对静态资源放行
                .excludePathPatterns("/**/*.js")
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/*.png")
                .excludePathPatterns("/**/*.jpg");
    }
}
