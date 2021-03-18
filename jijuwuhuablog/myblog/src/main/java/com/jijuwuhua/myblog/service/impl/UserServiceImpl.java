package com.jijuwuhua.myblog.service.impl;

import com.jijuwuhua.myblog.dao.UserRepository;
import com.jijuwuhua.myblog.pojo.User;
import com.jijuwuhua.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：chenjiajun
 * @description：用户服务接口实现类
 * @date ：2021/3/17 21:37
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository ;

    @Override
    public User getUser(String name, String password) {
        User user = userRepository.findByUsernameAndPassword(name, password);
        return user;
    }
}
