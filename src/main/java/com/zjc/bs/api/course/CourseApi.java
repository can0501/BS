package com.zjc.bs.api.course;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.course.Course;
import com.zjc.bs.entity.course.CourseCommit;
import com.zjc.bs.entity.course.CourseTask;
import com.zjc.bs.service.Couese.CourseService;
import com.zjc.bs.util.LayUI;
import com.zjc.bs.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("/commitTask")
    public Response commitTask(CourseCommit courseCommit,Integer type) {
        if(courseCommit.getId()==null)
        {

        if ( courseService.addCourseCommit(courseCommit)) {
            return Response.success(null, Msg.ADD_SUCCESS);
        }
        return Response.failure(Msg.ADD_FALIED);
        }else {
            if ( courseService.updateCourseCommit(courseCommit)) {
                return Response.success(null, Msg.UPD_SUCCESS);
            }
            return Response.failure(Msg.UPD_FALIED);
        }
    }
    @RequestMapping("/courseTaskListData")
    public LayUI courseTaskListData(CourseTask courseTask) {

        return LayUI.data(courseService.seletCourseTaskCount(courseTask),courseService.getCourseTaskByPage(courseTask));
    }
    @RequestMapping("/myCourseTaskListData")
    public LayUI myCourseTaskListData(CourseTask courseTask, HttpServletRequest request) {
        HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");
        courseTask.setPid(people.getId());

        return LayUI.data(courseService.seletCourseTaskCount(courseTask),courseService.getCourseTaskByPage(courseTask));
    }

    @RequestMapping("/courseCommitListData")
    public LayUI courseCommitListData(CourseCommit courseCommit,HttpServletRequest request) {
        HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");
        if(people.getRole()!=3)
            courseCommit.setCtid(people.getId());

        return LayUI.data(10,courseService.getCourseCommitByPage(courseCommit));
    }

}
