package com.zjc.bs.service.check;

import com.zjc.bs.entity.check.ExamSup;
import com.zjc.bs.entity.check.Plan;

import java.util.List;

public interface PlanService {
    List<Plan> getPlanByPage(Plan Plan);

    Plan getPlan(Plan plan);

    Boolean addPlan(Plan Plan);

    Boolean updatePlanTeacher(Plan Plan);
    Boolean updatePlanSup(Plan Plan);
    Boolean deletePlan(Plan Plan);


}
