package com.zjc.bs.service.Couese;

import com.zjc.bs.entity.course.Course;
import com.zjc.bs.entity.course.CourseCommit;
import com.zjc.bs.entity.course.CourseTask;

import java.util.List;

public interface CourseService {
    List<Course> getCourseByPage(Course course);

    CourseTask getCourseTask(CourseTask courseTask);

    CourseCommit getCourseCommit(CourseCommit courseCommit);

    Integer seletCourseCount(Course course);

    Integer seletCourseTaskCount(CourseTask courseTask);

    Boolean orderTask(Integer pid, Integer cid);

    List<CourseTask> getCourseTaskByPage(CourseTask courseTask);

    List<CourseCommit> getCourseCommitByPage(CourseCommit courseCommit);

    Boolean addCourseCommit(CourseCommit courseCommit);



    Boolean updateCourseCommit(CourseCommit courseCommit);
}
