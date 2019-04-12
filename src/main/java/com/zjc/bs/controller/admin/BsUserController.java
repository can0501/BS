package com.zjc.bs.controller.admin;

import com.zjc.bs.base.Response;
import com.zjc.bs.service.admin.BsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
@RequestMapping("/bsuser")
public class BsUserController {
    @Autowired
    BsUserService bsUserService;
    @RequestMapping("login")
    @ResponseBody
    public Response<Boolean> login() {

        if(bsUserService.login(null))
        return Response.success();
        return Response.failure("密码账号出错");
    }

    @RequestMapping("pass")
    public String pass() {
        return "index";
    }
}
