package com.zjc.bs.controller.check;

import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.ExamSup;
import com.zjc.bs.entity.check.ExamTeacher;
import com.zjc.bs.service.check.BigHouseWordService;
import com.zjc.bs.service.check.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    ExamService bigHouseWordService;

    @RequestMapping("/examTeacherList")
    public String ExamTeacherList(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/examTeacherList";
    }

    @RequestMapping("/examSupList")
    public String ExamSupList(HttpServletRequest request,Model model ) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/examSupList";
    }

    @RequestMapping("/examTeacherAdd")
    public String ExamTeacherAdd( HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/examTeacherAdd";
    }
    @RequestMapping("/examTeacherUpd")
    public String ExamTeacherUdp(ExamTeacher ExamTeacher, Model model ) {
//        model.addAttribute("id", id);
        model.addAttribute("courseDesignTeacher", bigHouseWordService.getExamTeacher(ExamTeacher));

        return "check/examTeacherUpd";
    }

    @RequestMapping("/examSupUpd")
    public String ExamSupUdp(ExamSup ExamSup, Model model) {
        model.addAttribute("courseDesignTeacher", bigHouseWordService.getExamSup(ExamSup));
        return "check/examSupUpd";
    }
}
