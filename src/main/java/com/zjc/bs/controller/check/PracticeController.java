package com.zjc.bs.controller.check;

import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.PracticeSup;
import com.zjc.bs.entity.check.PracticeTeacher;
import com.zjc.bs.service.check.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/practice")
public class PracticeController {
    @Autowired
    PracticeService practiceService;

    @RequestMapping("/practiceTeacherList")
    public String practiceTeacherList(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/practiceTeacherList";
    }

    @RequestMapping("/practiceSupList")
    public String practiceSupList(HttpServletRequest request,Model model ) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/practiceSupList";
    }

    @RequestMapping("/practiceTeacherAdd")
    public String practiceTeacherAdd( HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/practiceTeacherAdd";
    }
    @RequestMapping("/practiceTeacherUpd")
    public String practiceTeacherUdp(PracticeTeacher practiceTeacher, Model model ) {
//        model.addAttribute("id", id);
        model.addAttribute("courseDesignTeacher", practiceService.getPracticeTeacher(practiceTeacher));

        return "check/practiceTeacherUpd";
    }

    @RequestMapping("/practiceSupUpd")
    public String practiceSupUdp(PracticeSup practiceSup, Model model) {
        model.addAttribute("courseDesignTeacher", practiceService.getPracticeSup(practiceSup));
        return "check/practiceSupUpd";
    }
}
