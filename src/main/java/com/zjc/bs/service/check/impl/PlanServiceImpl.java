package com.zjc.bs.service.check.impl;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.check.Plan;
import com.zjc.bs.mapper.check.PlanMapper;
import com.zjc.bs.service.check.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    PlanMapper planMapper;
    @Override
    public List<Plan> getPlanByPage(Plan Plan) {
        PageHelper.startPage(Plan.getPage(), Plan.getLimit());

        return planMapper.select(Plan);
    }

    @Override
    public Plan getPlan(Plan plan) {
        return planMapper.selectByPrimaryKey(plan.getId());
    }

    @Override
    public Boolean addPlan(Plan Plan) {

        Plan.setStatus(0);

        if(planMapper.insert(Plan)!=0)
        return true;
        return false;
    }

    @Override
    public Boolean updatePlanTeacher(Plan Plan) {
        Plan res = planMapper.selectByPrimaryKey(Plan.getId());
        if(res.getStatus()==2)
            Plan.setStatus(3);
        if(planMapper.updateByPrimaryKeySelective(Plan)!=0)
            return true;
        return false;
    }

    @Override
    public Boolean updatePlanSup(Plan Plan) {
        if(planMapper.updateByPrimaryKeySelective(Plan)!=0)
            return true;
        return false;
    }


    @Override
    public Boolean deletePlan(Plan Plan) {
        if(planMapper.deleteByPrimaryKey(Plan)!=0)
            return true;
        return false;
    }
}
