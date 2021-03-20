package com.jijuwuhua.myblog.interceptor;

import com.jijuwuhua.myblog.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author ：chenjiajun
 * @description：登录拦截器
 * @date ：2021/3/20 16:21
 */
@Component
//注册到spring容器中去
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        try{
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("user");
            if (u != null){
                return true;
            }
            //没有登录则重定向到登录页面
            response.sendRedirect("/admin");

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
