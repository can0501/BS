package com.zjc.bs.service.Couese.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.course.Course;
import com.zjc.bs.entity.course.CourseTask;
import com.zjc.bs.mapper.course.CourseMapper;
import com.zjc.bs.mapper.course.CourseTaskMapper;
import com.zjc.bs.service.Couese.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    CourseTaskMapper courseTaskMapper;
    @Override
    public List<Course> getCourseByPage(Course course) {
        PageHelper.startPage(course.getPage(), course.getLimit());
        return courseMapper.getCouesePageByCondition(course);
    }

    @Override
    public Integer seletCourseCount(Course course) {
        return courseMapper.selectCountByCondition(course);
    }

    @Override
    public Integer seletCourseTaskCount(CourseTask courseTask) {
        return courseTaskMapper.selectCountCourseTask(courseTask);
    }

    @Override
    public Boolean orderTask(Integer pid,Integer cid) {
        if(courseTaskMapper.insertSelective(CourseTask.builder().cid(cid).pid(pid).status(0).createDate(new Date()).build())!=0)

        return true;
        return false;
    }

    @Override
    public List<CourseTask> getCourseTaskByPage(CourseTask courseTask) {
        PageHelper.startPage(courseTask.getPage(), courseTask.getLimit());

        return courseTaskMapper.getCourseTaskByPage(courseTask);
    }
}
