package com.itzyf.dao;

import com.itzyf.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/1 11:24
 */
@Repository
public interface UserDao {
    int add(User user);

    List<User> getAll();

    User getUser(int id);


    int delete(User user);

    int update(User user);

    List<User> find(Map<String, Object> map);

    @Select("SELECT COUNT(id) from user")
    Long getTotal();
}
