package com.jijuwuhua.myblog.service;

import com.jijuwuhua.myblog.pojo.User;
/**
* @Description:用户服务接口
* @Author: chenjiajun
* @Date: 2021/3/17
*/
public interface UserService {
    public User getUser(String name, String password);
}
