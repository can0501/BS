package com.zjc.bs.service.check.impl;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.check.CourseDesignSup;
import com.zjc.bs.entity.check.CourseDesignTeacher;
import com.zjc.bs.mapper.check.CourseDesignSupMapper;
import com.zjc.bs.mapper.check.CourseDesignTeacherMapper;
import com.zjc.bs.service.check.CourseDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseDesignImpl implements CourseDesign {
    @Autowired
    CourseDesignSupMapper courseDesignSupMapper;
    @Autowired
    CourseDesignTeacherMapper courseDesignTeacherMapper;
    @Override
    public List<CourseDesignTeacher> getCourseDesignTeacherByPage(CourseDesignTeacher courseDesignTeacher) {
        PageHelper.startPage(courseDesignTeacher.getPage(), courseDesignTeacher.getLimit());

        return courseDesignTeacherMapper.select(courseDesignTeacher);
    }

    @Override
    public List<CourseDesignSup> getCourseDesignSupByPage(CourseDesignSup courseDesignSup) {
        PageHelper.startPage(courseDesignSup.getPage(), courseDesignSup.getLimit());

        return courseDesignSupMapper.select(courseDesignSup);
    }

    @Override
    public Boolean addCourseDesignSup(CourseDesignSup courseDesignSup) {
        return null;
    }

    @Override
    public Boolean addCourseDesignTeacher(CourseDesignTeacher courseDesignTeacher) {
        courseDesignTeacher.setStatus(0);
        int i = courseDesignTeacherMapper.insert(courseDesignTeacher);
        if (i!=0) {
            if (courseDesignSupMapper.insert(CourseDesignSup.builder().dep(courseDesignTeacher.getDep()).classname(courseDesignTeacher.getClassname()).startyear(courseDesignTeacher.getStartyear()).coursename(courseDesignTeacher.getCoursename()).term(courseDesignTeacher.getTerm()).cdtid(courseDesignTeacher.getId()).status(0).build())!=0) {
               return true ;
            }


        }
        return false;
    }

    @Override
    public Boolean updateCourseDesignTeacher(CourseDesignTeacher courseDesignTeacher) {
        CourseDesignTeacher courseDesignTeacher1 = courseDesignTeacherMapper.selectByPrimaryKey(courseDesignTeacher.getId());

        int status=courseDesignTeacher1.getStatus();
        if (status == 2) {
            courseDesignTeacher.setStatus(3);
            if(courseDesignTeacherMapper.updateByPrimaryKeySelective(courseDesignTeacher)!=0) {

                CourseDesignSup courseDesignSup = courseDesignSupMapper.selectOne(CourseDesignSup.builder().dep(courseDesignTeacher.getDep()).cdtid(courseDesignTeacher.getId()).build());
                courseDesignSup.setStatus(3);
                courseDesignSupMapper.updateByPrimaryKeySelective(courseDesignSup);
                return true;
            }
            return false;

        }
        if(courseDesignTeacherMapper.updateByPrimaryKeySelective(courseDesignTeacher)!=0)
            return true;

        return false;
    }

    @Override
    public Boolean updateCourseDesignSup(CourseDesignSup courseDesignSup) {
        CourseDesignTeacher courseDesignTeacher = courseDesignTeacherMapper.selectByPrimaryKey(courseDesignSup.getCdtid());
        courseDesignTeacher.setStatus(courseDesignSup.getStatus());
        if(
        courseDesignTeacherMapper.updateByPrimaryKeySelective(courseDesignTeacher)!=0&&
        courseDesignSupMapper.updateByPrimaryKeySelective(courseDesignSup)!=0)
        return true;
        return false;
    }

    @Override
    public Boolean deleteCourseDesign(CourseDesignTeacher courseDesignTeacher) {
        courseDesignTeacher = courseDesignTeacherMapper.selectByPrimaryKey(courseDesignTeacher.getId());
        if (courseDesignTeacherMapper.deleteByPrimaryKey(courseDesignTeacher) != 0 && courseDesignSupMapper.delete(CourseDesignSup.builder().cdtid(courseDesignTeacher.getId()).build()) != 0) {
            return true;
        }

        return false;
    }
}
