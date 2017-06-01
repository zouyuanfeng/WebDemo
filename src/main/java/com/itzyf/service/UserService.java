package com.itzyf.service;

import com.itzyf.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    int add(User user);

    List<User> getAll();

    User getUser(int id);

    int delete(User user);

    int update(User user);

    List<User> find(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);
}