package com.zjc.bs.service.estimate.impl;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.estimate.EstimateSup;
import com.zjc.bs.entity.estimate.EstimateTeacher;
import com.zjc.bs.mapper.estimate.EstimateSupMapper;
import com.zjc.bs.mapper.estimate.EstimateTeacherMapper;
import com.zjc.bs.service.estimate.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class EstimateServiceImpl implements EstimateService {
    @Autowired
    EstimateSupMapper estimateSupMapper;
    @Autowired
    EstimateTeacherMapper estimateTeacherMapper;
    @Override
    public EstimateTeacher getEstimateTeacher(EstimateTeacher estimateTeacher) {
        return estimateTeacherMapper.selectByPrimaryKey(estimateTeacher.getId());
    }

    @Override
    public EstimateSup getEstimateSup(EstimateSup estimateSup) {
        return estimateSupMapper.selectOne(estimateSup );
    }

    @Override
    public List<EstimateTeacher> getEstimateTeacherByPage(EstimateTeacher estimateTeacher) {
        PageHelper.startPage(estimateTeacher.getPage(), estimateTeacher.getLimit());
        return estimateTeacherMapper.select(estimateTeacher);
    }

    @Override
    public List<EstimateSup> getEstimateSupByPage(EstimateSup estimateSup) {
        PageHelper.startPage(estimateSup.getPage(), estimateSup.getLimit());
        return estimateSupMapper.select(estimateSup);
    }

    @Override
    public Boolean addEstimateTeacher(EstimateTeacher estimateTeacher) {
        estimateTeacher.setStatus(0);
        estimateTeacher.setCreatetime(new Date());

        if (estimateTeacherMapper.insertSelective(estimateTeacher) != 0) {
            EstimateSup estimateSup = EstimateSup.builder().classname(estimateTeacher.getClassname()).coursename(estimateTeacher.getCoursename()).dep(estimateTeacher.getDep()).old(estimateTeacher.getOld()).etid(estimateTeacher.getId())
                  . teachername(estimateTeacher.getName())  .pcontent(estimateTeacher.getPcontent()).status(0).teacherold(estimateTeacher.getTeacherold()).old(estimateTeacher.getOld()).build();
            if(estimateSupMapper.insert(estimateSup)!=0)
                return true;
        }
        return false;
    }

    @Override
    public Boolean updateEstimateTeacher(EstimateTeacher estimateTeacher) {
        if(estimateTeacherMapper.updateByPrimaryKeySelective(estimateTeacher)!=0)
            return true;
        return false;
    }

    @Override
    public Boolean updateEstimateSup(EstimateSup estimateSup) {
        estimateSup.setStatus(1);
        estimateSup.setCreatetime(new Date());
        EstimateSup res = estimateSupMapper.selectByPrimaryKey(estimateSup.getId());

        if (estimateSupMapper.updateByPrimaryKeySelective(estimateSup) != 0
                && estimateTeacherMapper.updateByPrimaryKeySelective(EstimateTeacher.builder().id(res.getEtid()).status(1).build())!=0) {

            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteEstimateTeacher(EstimateTeacher estimateTeacher) {
        if(estimateTeacherMapper.deleteByPrimaryKey(estimateTeacher.getId())!=0)
        {
            EstimateSup estimateSup = estimateSupMapper.selectOne(EstimateSup.builder().etid(estimateTeacher.getId()).build());
            if(estimateSupMapper.deleteByPrimaryKey(estimateSup.getId())!=0)
                return true;
        }
        return false;
    }
}
