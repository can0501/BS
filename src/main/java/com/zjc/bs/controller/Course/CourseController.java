package com.zjc.bs.controller.Course;

import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.course.Course;
import com.zjc.bs.entity.course.CourseCommit;
import com.zjc.bs.entity.course.CourseTask;
import com.zjc.bs.service.Couese.CourseService;
import com.zjc.bs.util.LayUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @RequestMapping("/courseList")
    public String courseList( ) {
        return "/course/courseList";
    }

    @RequestMapping("/courseListMe")
    public String courseListMe(HttpServletRequest request,Model model) {

        HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("people", people);
        return "/course/courseListMe";
    }

    @RequestMapping("/courseTaskList")
    public String courseTaskList( ) {
        return "/course/courseTaskList";
    }

    @RequestMapping("/courseTaskAllList")
    public String courseTaskAllList( ) {
        return "/course/courseTaskAllList";
    }

    @RequestMapping("/courseCommitAdd")
    public String courseCommitAdd(Integer id, Model model,Integer type) {

        CourseCommit courseCommit=courseService.getCourseCommit(CourseCommit.builder().ctid(id).build());
        if (courseCommit == null) {
            courseCommit = CourseCommit.builder().build();
        }
        CourseTask courseTask = courseService.getCourseTask(CourseTask.builder().id(id).build());
        model.addAttribute("courseTask", courseTask);
        model.addAttribute("courseCommit", courseCommit);
        return "/course/courseCommitAdd";
    }
    @RequestMapping("/courseCommitList")
    public String courseCommitList(CourseCommit courseCommit) {


        return "/course/courseCommitList";
    }

}
