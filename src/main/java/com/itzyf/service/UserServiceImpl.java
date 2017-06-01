package com.itzyf.service;

import com.itzyf.bean.User;
import com.itzyf.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/1 11:34
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public int add(User user) {
        return userDao.add(user);
    }
}
