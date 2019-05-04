package com.zjc.bs.api.estimate;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.estimate.EstimateSup;
import com.zjc.bs.entity.estimate.EstimateTeacher;
import com.zjc.bs.service.estimate.EstimateService;
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
@RequestMapping("/estimate")
public class estimateApi {
    @Autowired
    EstimateService practiceService;

    @RequestMapping("/estimateTeacherListData")
    public LayUI EstimateTeacherListData(EstimateTeacher EstimateTeacher, HttpServletRequest request) {
        HttpSession session=request.getSession();
        People people = (People) session.getAttribute("people");
        EstimateTeacher.setPid(people.getId());
        List list = practiceService.getEstimateTeacherByPage(EstimateTeacher  );
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/estimateSupListData")
    public LayUI EstimateSupListData(EstimateSup EstimateSup, HttpServletRequest request) {

        List list = practiceService.getEstimateSupByPage(EstimateSup);
        return LayUI.data(list.size(), list);

    }
    @RequestMapping("/addEstimateTeacher")
    public Response addEstimateTeacher(@RequestBody EstimateTeacher EstimateTeacher, HttpServletRequest request) {
        if(practiceService.addEstimateTeacher(EstimateTeacher))
            return Response.success(null, Msg.ADD_SUCCESS);
        return Response.failure(Msg.ADD_FALIED);
    }
    @RequestMapping("/updEstimateTeacher")
    public Response updEstimateTeacher(@RequestBody EstimateTeacher EstimateTeacher, HttpServletRequest request) {
        if(practiceService.updateEstimateTeacher(EstimateTeacher))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }
    @RequestMapping("/deleteEstimateTeacher")
    public Response deleteEstimateTeacher(EstimateTeacher EstimateTeacher, HttpServletRequest request) {
        if(practiceService.deleteEstimateTeacher(EstimateTeacher))
            return Response.success(null, Msg.DEL_SUCCESS);
        return Response.failure(Msg.DEL_FALIED);
    }
    @RequestMapping("/updateEstimateSup")
    public Response updateEstimateSup( @RequestBody EstimateSup EstimateSup, HttpServletRequest request) {
        if(practiceService.updateEstimateSup(EstimateSup))
            return Response.success(null, Msg.UPD_SUCCESS);
        return Response.failure(Msg.UPD_FALIED);
    }


}
