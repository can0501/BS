package com.zjc.bs.controller.estimate;

import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.estimate.EstimateSup;
import com.zjc.bs.entity.estimate.EstimateTeacher;
import com.zjc.bs.service.estimate.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/estimate")
public class estimateController {
    @Autowired
    EstimateService bigHouseWordService;

    @RequestMapping("/estimateTeacherList")
    public String EstimateTeacherList(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "estimate/estimateTeacherList";
    }

    @RequestMapping("/estimateSupList")
    public String EstimateSupList(HttpServletRequest request,Model model ) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        return "estimate/estimateSupList";
    }

    @RequestMapping("/estimateTeacherAdd")
    public String EstimateTeacherAdd(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        model.addAttribute("id", people.getId());
        model.addAttribute("people", people);
        return "estimate/estimateTeacherAdd";
    }
    @RequestMapping("/estimateTeacherUpd")
    public String EstimateTeacherUdp(EstimateTeacher EstimateTeacher, Model model , HttpSession session) {
//        model.addAttribute("id", id);
        People people = (People) session.getAttribute("people");
        model.addAttribute("courseDesignTeacher", bigHouseWordService.getEstimateTeacher(EstimateTeacher));
        model.addAttribute("people", people);
        return "estimate/estimateTeacherUpd";
    }

    @RequestMapping("/estimateSupUpd")
    public String EstimateSupUdp(EstimateSup EstimateSup, Model model) {
        model.addAttribute("courseDesignTeacher", bigHouseWordService.getEstimateSup(EstimateSup));
        return "estimate/estimateSupUpd";
    }

    @RequestMapping("/estimateTeacherLook")
    public String estimateTeacherLook(EstimateSup EstimateSup, Model model) {
        model.addAttribute("courseDesignTeacher", bigHouseWordService.getEstimateSup(EstimateSup));
        return "estimate/estimateTeacherLook";
    }
}
