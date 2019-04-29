package com.zjc.bs.api.check;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.check.BigHouseWordSup;
import com.zjc.bs.entity.check.BigHouseWordTeacher;
import com.zjc.bs.service.check.BigHouseWordService;
import com.zjc.bs.service.check.PracticeService;
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
@RequestMapping("/bigHouseWork")
public class BigHouseWorkApi {
    @Autowired
    BigHouseWordService practiceService;

    @RequestMapping("/bigHouseWordTeacherListData")
    public LayUI BigHouseWordTeacherListData(BigHouseWordTeacher BigHouseWordTeacher, HttpServletRequest request) {
            HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");
        BigHouseWordTeacher.setPid(people.getId());
        List list = practiceService.getBigHouseWordTeacherByPage(BigHouseWordTeacher  );
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/bigHouseWordSupListData")
    public LayUI BigHouseWordSupListData(BigHouseWordSup BigHouseWordSup, HttpServletRequest request) {

        List list = practiceService.getBigHouseWordSupByPage(BigHouseWordSup);
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/addBigHouseWordTeacher")
    public Response addBigHouseWordTeacher(@RequestBody BigHouseWordTeacher BigHouseWordTeacher, HttpServletRequest request) {
            if(practiceService.addBigHouseWordTeacher(BigHouseWordTeacher))
                return Response.success(null, Msg.ADD_SUCCESS);
        return Response.failure(Msg.ADD_FALIED);
    }
    @RequestMapping("/updBigHouseWordTeacher")
    public Response updBigHouseWordTeacher(@RequestBody BigHouseWordTeacher BigHouseWordTeacher, HttpServletRequest request) {
        if(practiceService.updateBigHouseWordTeacher(BigHouseWordTeacher))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }
    @RequestMapping("/deleteBigHouseWordTeacher")
    public Response deleteBigHouseWordTeacher(BigHouseWordTeacher BigHouseWordTeacher, HttpServletRequest request) {
        if(practiceService.deleteBigHouseWordTeacher(BigHouseWordTeacher))
            return Response.success(null, Msg.DEL_SUCCESS);
        return Response.failure(Msg.DEL_FALIED);
    }
    @RequestMapping("/updateBigHouseWordSup")
    public Response updateBigHouseWordSup( @RequestBody BigHouseWordSup BigHouseWordSup, HttpServletRequest request) {
        if(practiceService.updateBigHouseWordSup(BigHouseWordSup))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }


}
