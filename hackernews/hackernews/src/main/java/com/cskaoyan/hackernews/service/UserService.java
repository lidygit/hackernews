package com.cskaoyan.hackernews.service;

import com.cskaoyan.hackernews.bean.User;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/18 15:51
 * @需求:
 * @思路说明:
 */
public interface UserService {

    User findUserById(Integer id);

    boolean register(User user);

    User login(User user);

    boolean isNameAvailable(String name);
}
