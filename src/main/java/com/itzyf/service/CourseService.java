package com.itzyf.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itzyf.bean.Course;
import com.itzyf.bean.PageResult;
import com.itzyf.dao.CourseDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("courseService")
public class CourseService {
    Logger LOGGER = Logger.getLogger(CourseService.class.getSimpleName());
    @Resource
    private CourseDao courseDao;


    public PageResult<List<Course>> getAllCourse(int pageNum, int pageSize) {
        LOGGER.info("pageNum:" + pageNum + "\tpageSize:" + pageSize);
        Page<Course> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> courseDao.findAll());
        PageResult<List<Course>> pageResult = new PageResult<>();
        pageResult.setList(page.getResult());
        pageResult.setTotalPage(page.getPages());
        pageResult.setTotalRecord(page.getTotal());
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        return pageResult;
    }

    public Course findCourseById(String cno) {
        return courseDao.findCourseById(cno);
    }

}
