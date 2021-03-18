package com.jijuwuhua.myblog.web.admin;

import com.jijuwuhua.myblog.pojo.User;
import com.jijuwuhua.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpSession;

/**
 * @author ：chenjiajun
 * @description：后台登录控制器
 * @date ：2021/3/17 21:43
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam  String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){
        User user = userService.getUser(username, password);

        if(user == null){
            redirectAttributes.addFlashAttribute("message","用户名或者密码错误");
            return "redirect:/admin";
        }
        else{
            //防止密码泄露
            user.setPassword(null);
            session.setAttribute("user",user);
            System.out.println(user.toString());
            return "admin/index";
        }
    }

    @GetMapping("/lagout")
    public String lagout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
