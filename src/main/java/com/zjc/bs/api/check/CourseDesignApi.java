package com.zjc.bs.api.check;

import com.zjc.bs.base.JsonHelper;
import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.CourseDesignSup;
import com.zjc.bs.entity.check.CourseDesignTeacher;
import com.zjc.bs.service.check.CourseDesign;
import com.zjc.bs.util.LayUI;
import com.zjc.bs.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/courseDesign")
public class CourseDesignApi {
    @Autowired
    JsonHelper jsonHelper;
    @Autowired
    CourseDesign courseDesign;
    @RequestMapping("/courseDesignTeacherListData")
    public LayUI courseDesignTeacherListData(CourseDesignTeacher courseDesignTeacher) {
        return LayUI.data(10, courseDesign.getCourseDesignTeacherByPage(courseDesignTeacher));
    }
    @RequestMapping("/courseDesignSupListData")
    public LayUI courseDesignSupListData(CourseDesignSup courseDesignSup) {
        return LayUI.data(10, courseDesign.getCourseDesignSupByPage(courseDesignSup));
    }
    @RequestMapping("/updateCourseDesignTeacher")
    public Response updateCourseDesignTeacher(String str) {
        CourseDesignTeacher courseDesignTeacher = jsonHelper.entity(CourseDesignTeacher.class, str);
        if(courseDesign.updateCourseDesignTeacher(courseDesignTeacher))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure( Msg.UPD_FALIED);
    }
    @RequestMapping("/addCourseDesignTeacher")
    public Response addCourseDesignTeacher(String  str, HttpServletRequest request) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        CourseDesignTeacher courseDesignTeacher = jsonHelper.entity(CourseDesignTeacher.class, str);
        courseDesignTeacher.setPid(people.getId());
        if(courseDesign.addCourseDesignTeacher(courseDesignTeacher))
            return Response.success(null, Msg.ADD_SUCCESS);
        return Response.failure( Msg.ADD_FALIED);
    }
    @RequestMapping("/updateCourseDesignSup")
    public Response updateCourseDesignSup(String str) {
        CourseDesignSup courseDesignSup = jsonHelper.entity(CourseDesignSup.class, str);
        if(courseDesign.updateCourseDesignSup(courseDesignSup))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure( Msg.UPD_FALIED);
    }

    @RequestMapping("/delete")
    public Response delete(CourseDesignTeacher courseDesignTeacher) {

        if(courseDesign.deleteCourseDesign(courseDesignTeacher))
            return Response.success(null, Msg.DEL_SUCCESS);
        return Response.failure( Msg.DEL_FALIED);
    }
}
