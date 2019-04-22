package com.zjc.bs.mapper.course;

import com.zjc.bs.entity.course.CourseTask;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CourseTaskMapper extends Mapper<CourseTask> {
    List<CourseTask> getCourseTaskByPage(CourseTask courseTask);

    Integer selectCountCourseTask(CourseTask courseTask);

}