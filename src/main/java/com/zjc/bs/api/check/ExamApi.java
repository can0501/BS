package com.zjc.bs.api.check;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.ExamSup;
import com.zjc.bs.entity.check.ExamTeacher;
import com.zjc.bs.service.check.BigHouseWordService;
import com.zjc.bs.service.check.ExamService;
import com.zjc.bs.util.LayUI;
import com.zjc.bs.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamApi {
    @Autowired
    ExamService practiceService;

    @RequestMapping("/examTeacherListData")
    public LayUI ExamTeacherListData(ExamTeacher ExamTeacher, HttpServletRequest request) {
            HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");
        ExamTeacher.setPid(people.getId());
        List list = practiceService.getExamTeacherByPage(ExamTeacher  );
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/examSupListData")
    public LayUI ExamSupListData(ExamSup ExamSup, HttpServletRequest request) {

        List list = practiceService.getExamSupByPage(ExamSup);
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/addExamTeacher")
    public Response addExamTeacher(@RequestBody ExamTeacher ExamTeacher, HttpServletRequest request) {
            if(practiceService.addExamTeacher(ExamTeacher))
                return Response.success(null, Msg.ADD_SUCCESS);
        return Response.failure(Msg.ADD_FALIED);
    }
    @RequestMapping("/updExamTeacher")
    public Response updExamTeacher(@RequestBody ExamTeacher ExamTeacher, HttpServletRequest request) {
        if(practiceService.updateExamTeacher(ExamTeacher))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }
    @RequestMapping("/deleteExamTeacher")
    public Response deleteExamTeacher(ExamTeacher ExamTeacher, HttpServletRequest request) {
        if(practiceService.deleteExamTeacher(ExamTeacher))
            return Response.success(null, Msg.DEL_SUCCESS);
        return Response.failure(Msg.DEL_FALIED);
    }
    @RequestMapping("/updateExamSup")
    public Response updateExamSup( @RequestBody ExamSup ExamSup, HttpServletRequest request) {
        if(practiceService.updateExamSup(ExamSup))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }


}
