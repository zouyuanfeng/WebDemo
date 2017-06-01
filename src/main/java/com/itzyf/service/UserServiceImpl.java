package com.itzyf.service;

import com.itzyf.bean.User;
import com.itzyf.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> find(Map<String, Object> map) {
        return userDao.find(map);
    }

    @Override
    public Long getTotal() {
        return userDao.getTotal();
    }
}
