package com.zjc.bs.controller.check;

import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.CourseDesignSup;
import com.zjc.bs.entity.check.CourseDesignTeacher;
import com.zjc.bs.mapper.check.CourseDesignSupMapper;
import com.zjc.bs.mapper.check.CourseDesignTeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/courseDesign")
public class CourseDesignController {
    @RequestMapping("/courseDesignTeacherList")
    public String courseDesignTeacherList() {
        return "/check/courseDesignTeacherList";
    }
    @RequestMapping("/courseDesignSupList")
    public String courseDesignSupList() {
        return "/check/courseDesignSupList";
    }


    @RequestMapping("/courseDesignTeacherAdd")
    public String courseDesignTeacherAdd(HttpServletRequest request, Model model)
    {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("people", people);
        return "/check/courseDesignTeacherAdd";
    }

    @Autowired
    CourseDesignTeacherMapper courseDesignTeacherMapper;
    @RequestMapping("/courseDesignTeacherUpd")
    public String courseDesignTeacherUpdate(HttpServletRequest request, Model model,Integer id)
    {

       CourseDesignTeacher courseDesignTeacher= courseDesignTeacherMapper.selectByPrimaryKey(id);
        model.addAttribute("id", id);
        model.addAttribute("courseDesignTeacher", courseDesignTeacher);
        return "/check/courseDesignTeacherUpd";
    }


@Autowired
    CourseDesignSupMapper courseDesignSupMapper;
    @RequestMapping("/courseDesignSupUpdate")
    public String courseDesignSupUpdate(HttpServletRequest request, Model model,Integer id)
    {

        CourseDesignSup courseDesignSup= courseDesignSupMapper.selectByPrimaryKey(id);
        model.addAttribute("id", id);
        model.addAttribute("courseDesignTeacher", courseDesignSup);
        return "/check/courseDesignSupUpd";
    }
}
