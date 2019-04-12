package com.zjc.bs.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class first {
    @RequestMapping("/")
    public  String first() {
        return "forward:/login.html";
    }

}
