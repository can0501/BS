package com.zjc.bs.api.check;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;

import com.zjc.bs.entity.check.Plan;
import com.zjc.bs.service.check.PlanService;
import com.zjc.bs.service.check.PlanService;
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
@RequestMapping("/plan")
public class PlanApi {
    @Autowired
    PlanService planService;

    @RequestMapping("/planTeacherListData")
    public LayUI planTeacherListData(Plan plan, HttpServletRequest request) {
            HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");
        plan.setPid(people.getId());
        List list = planService.getPlanByPage(plan  );
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/planSupListData")
    public LayUI PlanSupListData(Plan PlanSup, HttpServletRequest request) {

        List list = planService.getPlanByPage(PlanSup);
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/addPlanTeacher")
    public Response addPlanTeacher(@RequestBody Plan PlanTeacher, HttpServletRequest request) {
            if(planService.addPlan(PlanTeacher))
                return Response.success(null, Msg.ADD_SUCCESS);
        return Response.failure(Msg.ADD_FALIED);
    }
    @RequestMapping("/updPlanTeacher")
    public Response updPlanTeacher(@RequestBody Plan  PlanTeacher, HttpServletRequest request) {
        if(planService.updatePlanTeacher(PlanTeacher))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }
    @RequestMapping("/deletePlanTeacher")
    public Response deletePlanTeacher(Plan  PlanTeacher, HttpServletRequest request) {
        if(planService.deletePlan(PlanTeacher))
            return Response.success(null, Msg.DEL_SUCCESS);
        return Response.failure(Msg.DEL_FALIED);
    }
    @RequestMapping("/updatePlanSup")
    public Response updatePlanSup(   Plan  PlanSup, HttpServletRequest request) {
        if(planService.updatePlanSup(PlanSup))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }


}
