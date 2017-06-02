package com.itzyf.dao;

import com.itzyf.bean.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/2 10:34
 */
@Repository
public interface CourseDao {

    List<Course> findAll();

    //3-105
    Course findCourseById(String cno);
}
