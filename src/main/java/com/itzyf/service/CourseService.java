package com.itzyf.service;

import com.itzyf.bean.Course;
import com.itzyf.dao.CourseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("courseService")
public class CourseService {

    @Resource
    private CourseDao courseDao;


    public List<Course> getAllCourse() {
        return courseDao.findAll();
    }

    public Course findCourseById(String cno) {
        return courseDao.findCourseById(cno);
    }

}
