package com.zjc.bs.mapper.course;

import com.zjc.bs.entity.course.CourseCommit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CourseCommitMapper extends Mapper<CourseCommit> {
    List<CourseCommit> getCourseCommitByPage(CourseCommit courseCommit);

}