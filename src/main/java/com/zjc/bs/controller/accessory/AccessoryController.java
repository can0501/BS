package com.zjc.bs.controller.accessory;

import com.zjc.bs.util.UploadRoot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
@RequestMapping("/upload")

public class AccessoryController {
    @RequestMapping("/photoAdd")
    public String photoAdd(Integer id, Integer type,Model model) {
        model.addAttribute("fid", id
        );
        model.addAttribute("ftype", UploadRoot.types[type]);

        return "/accessory/add";
    }
}
