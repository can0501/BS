package com.zjc.bs.api.course;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.course.Course;
import com.zjc.bs.entity.course.CourseTask;
import com.zjc.bs.service.Couese.CourseService;
import com.zjc.bs.util.LayUI;
import com.zjc.bs.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseApi {
    @Autowired
    CourseService courseService;
    @RequestMapping("/courseListData")
    public LayUI courseListData(Course course) {
        List list = courseService.getCourseByPage(course);
        int i = courseService.seletCourseCount(course);
        return LayUI.data(i,list );
    }
    @RequestMapping("/orderTask")
    public Response orderTask(Integer pid, Integer cid) {
        if (courseService.orderTask(pid, cid)) {
            return Response.success(null, Msg.ADD_SUCCESS);
        }
        return Response.failure(Msg.ADD_FALIED);
    }
    @RequestMapping("/courseTaskListData")
    public LayUI courseTaskListData(CourseTask courseTask) {

        return LayUI.data(courseService.seletCourseTaskCount(courseTask),courseService.getCourseTaskByPage(courseTask));
    }
}
