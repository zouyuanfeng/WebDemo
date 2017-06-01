package com.itzyf.dao;

import com.itzyf.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/1 11:24
 */
@Repository
public interface UserDao {
    int add(User user);
}
