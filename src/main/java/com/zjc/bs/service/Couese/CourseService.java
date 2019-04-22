package com.zjc.bs.service.Couese;

import com.zjc.bs.entity.course.Course;
import com.zjc.bs.entity.course.CourseTask;

import java.util.List;

public interface CourseService {
    List<Course> getCourseByPage(Course course);

    Integer seletCourseCount(Course course);

    Integer seletCourseTaskCount(CourseTask courseTask);

    Boolean orderTask(Integer pid, Integer cid);

    List<CourseTask> getCourseTaskByPage(CourseTask courseTask);
}
