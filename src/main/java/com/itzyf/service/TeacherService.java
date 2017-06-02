package com.itzyf.service;

import com.itzyf.bean.Teacher;
import com.itzyf.dao.TeacherDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("teacherService")
public class TeacherService {

    @Resource
    private TeacherDao teacherDao;

    public int insert(Teacher pojo) {
        return teacherDao.insert(pojo);
    }

    public int insertSelective(Teacher pojo) {
        return teacherDao.insertSelective(pojo);
    }

    public int insertList(List<Teacher> pojos) {
        return teacherDao.insertList(pojos);
    }

    public int update(Teacher pojo) {
        return teacherDao.update(pojo);
    }

    public List<Teacher> getAllTeacher() {
        return teacherDao.findAll();
    }

}
