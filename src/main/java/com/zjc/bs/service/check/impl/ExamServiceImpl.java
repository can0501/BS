package com.zjc.bs.service.check.impl;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.check.ExamSup;
import com.zjc.bs.entity.check.ExamTeacher;
import com.zjc.bs.mapper.check.ExamSupMapper;
import com.zjc.bs.mapper.check.ExamTeacherMapper;
import com.zjc.bs.service.check.BigHouseWordService;
import com.zjc.bs.service.check.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamSupMapper ExamSupMapper;
    @Autowired
    ExamTeacherMapper ExamTeacherMapper;

    @Override
    public List<ExamTeacher> getExamTeacherByPage(ExamTeacher practiceTeacher) {
        PageHelper.startPage(practiceTeacher.getPage(), practiceTeacher.getLimit());


        return ExamTeacherMapper.select(practiceTeacher);
    }

    @Override
    public List<ExamSup> getExamSupByPage(ExamSup practiceSup) {
        PageHelper.startPage(practiceSup.getPage(), practiceSup.getLimit());
        return ExamSupMapper.select(practiceSup);
    }

    @Override
    public Boolean addExamTeacher(ExamTeacher practiceTeacher) {
        practiceTeacher.setStatus(0);

        if (ExamTeacherMapper.insert(practiceTeacher) != 0
                && ExamSupMapper.insert(ExamSup.builder().pteachername(practiceTeacher.getPteachername()).papernum(practiceTeacher.getPapernum()).term(practiceTeacher.getTerm()).dep(practiceTeacher.getDep()).etid(practiceTeacher.getId()).status(0).coursename(practiceTeacher.getCoursename()).classname(practiceTeacher.getClassname()).startyear(practiceTeacher.getStartyear()).build())!=0
                ) {
            return true;

        }
        return false;
    }

    @Override
    public Boolean updateExamTeacher(ExamTeacher practiceTeacher) {
        ExamTeacher teacherSelect = ExamTeacherMapper.selectByPrimaryKey(practiceTeacher.getId());
        ExamSup practiceSup = ExamSupMapper.selectOne(ExamSup.builder().etid(teacherSelect.getId()).build());
        practiceSup.setDep(practiceTeacher.getDep());
        practiceSup.setStartyear(practiceTeacher.getStartyear());
        practiceSup.setTerm(practiceTeacher.getTerm());
        practiceSup.setCoursename(practiceTeacher.getCoursename());
        practiceSup.setClassname(practiceTeacher.getClassname());
        practiceSup.setPapernum(practiceTeacher.getPapernum());
        practiceSup.setPteachername(practiceTeacher.getPteachername());
        int status = teacherSelect.getStatus();
        if (status == 2) {
            practiceTeacher.setStatus(3);


            practiceSup.setStatus(3);
            if(ExamTeacherMapper.updateByPrimaryKeySelective(practiceTeacher)!=0&&
                    ExamSupMapper.updateByPrimaryKeySelective(practiceSup)!=0)
                return true;
            return  false;
        }
        if(ExamTeacherMapper.updateByPrimaryKeySelective(practiceTeacher)!=0&&ExamSupMapper.updateByPrimaryKeySelective(practiceSup)!=0)
        return true;
        return false;
    }

    @Override
    public Boolean updateExamSup(ExamSup practiceSup) {
        ExamSup supSelect = ExamSupMapper.selectByPrimaryKey(practiceSup.getId());
        ExamTeacher practiceTeacher = ExamTeacher.builder().id(supSelect.getEtid()).status(practiceSup.getStatus()).build();
        if (
                ExamSupMapper.updateByPrimaryKeySelective(practiceSup) != 0
                        && ExamTeacherMapper.updateByPrimaryKeySelective(practiceTeacher) != 0
                ) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteExamTeacher(ExamTeacher practiceTeacher) {
        if (ExamTeacherMapper.deleteByPrimaryKey(practiceTeacher) != 0
             &&ExamSupMapper.delete(ExamSup.builder().etid(practiceTeacher.getId()).build())!=0){
            return true;
        }
        return false;
    }

    @Override
    public ExamSup getExamSup(ExamSup practiceSup) {
        return ExamSupMapper.selectByPrimaryKey(practiceSup);
    }

    @Override
    public ExamTeacher getExamTeacher(ExamTeacher practiceTeacher) {
        return ExamTeacherMapper.selectByPrimaryKey(practiceTeacher);
    }
}
