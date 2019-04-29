package com.zjc.bs.controller.check;

import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.BigHouseWordSup;
import com.zjc.bs.entity.check.BigHouseWordTeacher;
import com.zjc.bs.service.check.BigHouseWordService;
import com.zjc.bs.service.check.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/bigHouseWork")
public class BigHouseWorkController {
    @Autowired
    BigHouseWordService bigHouseWordService;

    @RequestMapping("/bigHouseWordTeacherList")
    public String BigHouseWordTeacherList(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/bigHouseWordTeacherList";
    }

    @RequestMapping("/bigHouseWordSupList")
    public String BigHouseWordSupList(HttpServletRequest request,Model model ) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/bigHouseWordSupList";
    }

    @RequestMapping("/bigHouseWordTeacherAdd")
    public String BigHouseWordTeacherAdd( HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "check/bigHouseWordTeacherAdd";
    }
    @RequestMapping("/bigHouseWordTeacherUpd")
    public String BigHouseWordTeacherUdp(BigHouseWordTeacher BigHouseWordTeacher, Model model ) {
//        model.addAttribute("id", id);
        model.addAttribute("courseDesignTeacher", bigHouseWordService.getBigHouseWordTeacher(BigHouseWordTeacher));

        return "check/bigHouseWordTeacherUpd";
    }

    @RequestMapping("/bigHouseWordSupUpd")
    public String BigHouseWordSupUdp(BigHouseWordSup BigHouseWordSup, Model model) {
        model.addAttribute("courseDesignTeacher", bigHouseWordService.getBigHouseWordSup(BigHouseWordSup));
        return "check/bigHouseWordSupUpd";
    }
}
