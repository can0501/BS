package com.zjc.bs.controller.check;

import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.Plan;
  import com.zjc.bs.service.check.PlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    PlanService planService;

    @RequestMapping("/planTeacherList")
    public String planTeacherList(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/planTeacherList";
    }

    @RequestMapping("/planSupList")
    public String planSupList(HttpServletRequest request,Model model ) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/planSupList";
    }

    @RequestMapping("/planTeacherAdd")
    public String planTeacherAdd( HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/planTeacherAdd";
    }
    @RequestMapping("/planTeacherUpd")
    public String planTeacherUdp(Plan planTeacher, Model model ) {
//        model.addAttribute("id", id);
        model.addAttribute("courseDesignTeacher", planService.getPlan(planTeacher));

        return "check/planTeacherUpd";
    }

    @RequestMapping("/planSupUpd")
    public String planSupUdp(Plan planSup, Model model) {
        model.addAttribute("courseDesignTeacher", planService.getPlan(planSup));
        return "check/planSupUpd";
    }
}
