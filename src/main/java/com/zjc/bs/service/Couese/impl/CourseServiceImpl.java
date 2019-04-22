package com.zjc.bs.service.Couese.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.course.Course;
import com.zjc.bs.entity.course.CourseCommit;
import com.zjc.bs.entity.course.CourseTask;
import com.zjc.bs.mapper.admin.PeopleMapper;
import com.zjc.bs.mapper.course.CourseCommitMapper;
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
    @Autowired
    CourseCommitMapper courseCommitMapper;
    @Autowired
    PeopleMapper peopleMapper;
    @Override
    public List<Course> getCourseByPage(Course course) {
        PageHelper.startPage(course.getPage(), course.getLimit());
        return courseMapper.getCouesePageByCondition(course);
    }

    @Override
    public CourseTask getCourseTask(CourseTask courseTask) {
        CourseTask res=courseTaskMapper.selectByPrimaryKey(courseTask.getId());
        Course course = courseMapper.selectByPrimaryKey(res.getCid());
        People people = peopleMapper.selectByPrimaryKey(res.getPid());
        People teacher = peopleMapper.selectByPrimaryKey(course.getTid());
        res.setPname(people.getName());
        res.setCname(course.getName());
        res.setTeacher(teacher.getName());

        return res;
    }

    @Override
    public CourseCommit getCourseCommit(CourseCommit courseCommit) {
        return courseCommitMapper.selectOne(courseCommit);
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

    @Override
    public List<CourseCommit> getCourseCommitByPage(CourseCommit courseCommit) {
        PageHelper.startPage(courseCommit.getPage(), courseCommit.getLimit());

        return courseCommitMapper.getCourseCommitByPage(courseCommit);

    }


    @Override
    public Boolean addCourseCommit(CourseCommit courseCommit) {
        courseCommit.setCreatetime(new Date());
        CourseTask courseTask = courseTaskMapper.selectOne(CourseTask.builder().id(courseCommit.getCtid()).build());
        courseTask.setStatus(1);
        courseTaskMapper.updateByPrimaryKeySelective(courseTask);
        int i=  courseCommitMapper.insertSelective(courseCommit);
        if(i!=0)
        return true;
        return false;
    }

    @Override
    public Boolean updateCourseCommit(CourseCommit courseCommit) {
        int i = courseCommitMapper.updateByPrimaryKeySelective(courseCommit);
        if(i!=0)
            return true;
        return false;
    }
}
