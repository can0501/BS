package com.zjc.bs.controller.Course;

import com.zjc.bs.entity.course.Course;
import com.zjc.bs.service.Couese.CourseService;
import com.zjc.bs.util.LayUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @RequestMapping("/courseList")
    public String courseList( ) {
        return "/course/courseList";
    }
    @RequestMapping("/courseTaskList")
    public String courseTaskList( ) {
        return "/course/courseTaskList";
    }


}
