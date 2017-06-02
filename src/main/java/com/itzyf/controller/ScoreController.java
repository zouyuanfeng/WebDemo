package com.itzyf.controller;

import com.itzyf.bean.Course;
import com.itzyf.bean.PageResult;
import com.itzyf.bean.Result;
import com.itzyf.bean.Teacher;
import com.itzyf.service.CourseService;
import com.itzyf.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/2 9:55
 */
@RequestMapping("score")
@RestController
public class ScoreController extends BaseController {

    private final TeacherService teacherService;
    private final CourseService courseService;

    @Autowired
    public ScoreController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @RequestMapping("/allTeacher")
    public Result<List<Teacher>> getAllTeacher() {
        return createResult(teacherService.getAllTeacher());
    }

    @RequestMapping("/allCourse")
    public Result<PageResult<List<Course>>> getAllCourse(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        return createResult(courseService.getAllCourse(pageNum,pageSize));
    }

    @RequestMapping("/{cno}")
    public Result<Course> findCourseById(@PathVariable String cno) {
        return createResult(courseService.findCourseById(cno));
    }


}
