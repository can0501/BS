package com.zjc.bs.api.check;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.PracticeSup;
import com.zjc.bs.entity.check.PracticeTeacher;
import com.zjc.bs.service.check.PracticeService;
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
@RequestMapping("/practice")
public class PracticeApi {
    @Autowired
    PracticeService practiceService;

    @RequestMapping("/practiceTeacherListData")
    public LayUI practiceTeacherListData(PracticeTeacher practiceTeacher, HttpServletRequest request) {
            HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");
        practiceTeacher.setPid(people.getId());
        List list = practiceService.getPracticeTeacherByPage(practiceTeacher  );
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/practiceSupListData")
    public LayUI practiceSupListData(PracticeSup practiceSup, HttpServletRequest request) {

        List list = practiceService.getPracticeSipByPage(practiceSup);
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/addPracticeTeacher")
    public Response addPracticeTeacher(@RequestBody PracticeTeacher PracticeTeacher, HttpServletRequest request) {
            if(practiceService.addPracticeTeacher(PracticeTeacher))
                return Response.success(null, Msg.ADD_SUCCESS);
        return Response.failure(Msg.ADD_FALIED);
    }
    @RequestMapping("/updPracticeTeacher")
    public Response updPracticeTeacher(@RequestBody PracticeTeacher PracticeTeacher, HttpServletRequest request) {
        if(practiceService.updatePracticeTeacher(PracticeTeacher))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }
    @RequestMapping("/deletePracticeTeacher")
    public Response deletePracticeTeacher(PracticeTeacher PracticeTeacher, HttpServletRequest request) {
        if(practiceService.deletePracticeTeacher(PracticeTeacher))
            return Response.success(null, Msg.DEL_SUCCESS);
        return Response.failure(Msg.DEL_FALIED);
    }
    @RequestMapping("/updatePracticeSup")
    public Response updatePracticeSup( @RequestBody PracticeSup practiceSup, HttpServletRequest request) {
        if(practiceService.updatePracticeSup(practiceSup))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }


}
