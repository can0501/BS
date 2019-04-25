package com.zjc.bs.service.check;

import com.zjc.bs.entity.check.CourseDesignSup;
import com.zjc.bs.entity.check.CourseDesignTeacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseDesign {
    List<CourseDesignTeacher> getCourseDesignTeacherByPage(CourseDesignTeacher courseDesignTeacher);
    List<CourseDesignSup> getCourseDesignSupByPage(CourseDesignSup courseDesignSup);

    Boolean addCourseDesignSup(CourseDesignSup courseDesignSup);

    Boolean addCourseDesignTeacher(CourseDesignTeacher courseDesignTeacher);

    Boolean updateCourseDesignTeacher(CourseDesignTeacher courseDesignTeacher);
    Boolean updateCourseDesignSup(CourseDesignSup courseDesignSup);

    Boolean deleteCourseDesign(CourseDesignTeacher courseDesignTeacher);





}
