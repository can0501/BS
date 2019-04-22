package com.zjc.bs.controller.admin;

import com.zjc.bs.entity.admin.People;
import com.zjc.bs.service.admin.PeoplerService;
import com.zjc.bs.util.LayUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    PeoplerService peoplerService;
    @RequestMapping("/list")
    public String list(){
        return "/admin/list";}
    @RequestMapping("/add")
    public String add(){
        return "/admin/add";}
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        model.addAttribute("people", peoplerService.get(id));
        return "/admin/update";}
    @RequestMapping("/detail")
    public String detail(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("people", peoplerService.get(people.getId()));
        return "/admin/detail";}


}
