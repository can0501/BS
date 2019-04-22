package com.zjc.bs.mapper.course;

import com.zjc.bs.entity.course.Course;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CourseMapper extends Mapper<Course> {

    List<Course> getCouesePageByCondition(Course course);

    Integer selectCountByCondition(Course course);
}