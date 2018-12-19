package com.cskaoyan.hackernews.service.impl;

import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.mapper.UserMapper;
import com.cskaoyan.hackernews.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/18 15:52
 * @需求:
 * @思路说明:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public boolean register(User user) {

        Random random = new Random();
        int i = random.nextInt(999);
        user.setHeadUrl("https://images.nowcoder.com/head/"+i+"m.png");

        int register = userMapper.register(user);
        if (register==1){
            return true;
        }

        return false;
    }

    @Override
    public User login(User user) {
        User login = userMapper.login(user);

        return login;
    }

    @Override
    public boolean isNameAvailable(String name) {

        User user = userMapper.selectUserByName(name);
        if (user==null){
            return  true;
        }
        return false;
    }


}
