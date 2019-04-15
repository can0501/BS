package com.zjc.bs.controller.admin;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.service.admin.PeoplerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/bsuser")
public class LoginController {
    @Autowired
    PeoplerService peoplerService;
    @RequestMapping("login")
    @ResponseBody
    public Response<Boolean> login(People people, HttpServletRequest request) {

        People people1=peoplerService.login(people);
        if(people1!=null){
            HttpSession session = request.getSession();
            session.setAttribute("login",true);
            people.setPassword("");
            session.setAttribute("people",people1);
            return Response.success();
        }
        return Response.failure("密码账号出错");
    }

    @RequestMapping("pass")
    public String pass(HttpServletRequest request, Model model) {
            HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");

        model.addAttribute("people", people);
        return "bsindex";
    }
}
