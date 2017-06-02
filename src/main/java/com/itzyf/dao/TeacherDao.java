package com.itzyf.dao;

import com.itzyf.bean.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    int insert(Teacher pojo);

    int insertSelective(Teacher pojo);

    int insertList(List<Teacher> pojo);

    int update(Teacher pojo);

    List<Teacher> findAll();
}
