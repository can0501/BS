package com.zjc.bs.controller.check;

import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.Paper;
import com.zjc.bs.entity.check.Plan;
import com.zjc.bs.service.check.PaperService;
import com.zjc.bs.service.check.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    PaperService paperService;

    @RequestMapping("/paperTeacherList")
    public String paperTeacherList(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/paperTeacherList";
    }

    @RequestMapping("/paperSupList")
    public String paperSupList(HttpServletRequest request,Model model ) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/paperSupList";
    }

    @RequestMapping("/paperTeacherAdd")
    public String paperTeacherAdd( HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/paperTeacherAdd";
    }
    @RequestMapping("/paperTeacherUpd")
    public String paperTeacherUdp(Paper paperTeacher, Model model ) {
//        model.addAttribute("id", id);
        model.addAttribute("courseDesignTeacher", paperService.getPaper(paperTeacher));

        return "check/paperTeacherUpd";
    }

    @RequestMapping("/paperSupUpd")
    public String paperSupUdp(Paper paperSup, Model model) {
        model.addAttribute("courseDesignTeacher", paperService.getPaper(paperSup));
        return "check/paperSupUpd";
    }
}
