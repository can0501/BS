package com.zjc.bs.api.check;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;

import com.zjc.bs.entity.check.Paper;
import com.zjc.bs.service.check.PaperService;
import com.zjc.bs.util.LayUI;
import com.zjc.bs.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperApi {
    @Autowired
    PaperService paperService;

    @RequestMapping("/paperTeacherListData")
    public LayUI paperTeacherListData(Paper paper, HttpServletRequest request) {
            HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");
        paper.setPid(people.getId());
        List list = paperService.getPaperByPage(paper  );
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/paperSupListData")
    public LayUI paperSupListData(Paper paperSup, HttpServletRequest request) {

        List list = paperService.getPaperByPage(paperSup);
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/addpaperTeacher")
    public Response addpaperTeacher(@RequestBody Paper paperTeacher, HttpSession session) {
        People people = (People) session.getAttribute("people");
        paperTeacher.setPid(people.getId());
            if(paperService.addPaper(paperTeacher))
                return Response.success(null, Msg.ADD_SUCCESS);
        return Response.failure(Msg.ADD_FALIED);
    }
    @RequestMapping("/updpaperTeacher")
    public Response updpaperTeacher(@RequestBody Paper  paperTeacher, HttpServletRequest request) {
        if(paperService.updatePaperSup(paperTeacher))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }
    @RequestMapping("/deletepaperTeacher")
    public Response deletepaperTeacher(Paper  paperTeacher, HttpServletRequest request) {
        if(paperService.deletePaper(paperTeacher))
            return Response.success(null, Msg.DEL_SUCCESS);
        return Response.failure(Msg.DEL_FALIED);
    }
    @RequestMapping("/updatepaperSup")
    public Response updatepaperSup(   Paper  paperSup, HttpServletRequest request) {
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("people");
        paperSup.setCheckname(people.getName());
        if(paperService.updatePaperSup(paperSup))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }


}
