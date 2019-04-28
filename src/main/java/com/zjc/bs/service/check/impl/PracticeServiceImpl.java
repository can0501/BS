package com.zjc.bs.service.check.impl;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.check.PracticeSup;
import com.zjc.bs.entity.check.PracticeTeacher;
import com.zjc.bs.mapper.check.PracticeSupMapper;
import com.zjc.bs.mapper.check.PracticeTeacherMapper;
import com.zjc.bs.service.check.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PracticeServiceImpl implements PracticeService {
    @Autowired
    PracticeSupMapper practiceSupMapper;
    @Autowired
    PracticeTeacherMapper practiceTeacherMapper;

    @Override
    public List<PracticeTeacher> getPracticeTeacherByPage(PracticeTeacher practiceTeacher) {
        PageHelper.startPage(practiceTeacher.getPage(), practiceTeacher.getLimit());


        return practiceTeacherMapper.select(practiceTeacher);
    }

    @Override
    public List<PracticeSup> getPracticeSipByPage(PracticeSup practiceSup) {
        PageHelper.startPage(practiceSup.getPage(), practiceSup.getLimit());
        return practiceSupMapper.select(practiceSup);
    }

    @Override
    public Boolean addPracticeTeacher(PracticeTeacher practiceTeacher) {
        practiceTeacher.setStatus(0);

        if (practiceTeacherMapper.insert(practiceTeacher) != 0
                && practiceSupMapper.insert(PracticeSup.builder().term(practiceTeacher.getTerm()).dep(practiceTeacher.getDep()).ptid(practiceTeacher.getId()).status(0).coursename(practiceTeacher.getCoursename()).classname(practiceTeacher.getClassname()).startyear(practiceTeacher.getStartyear()).build())!=0
                ) {
            return true;

        }
        return false;
    }

    @Override
    public Boolean updatePracticeTeacher(PracticeTeacher practiceTeacher) {
        PracticeTeacher teacherSelect = practiceTeacherMapper.selectByPrimaryKey(practiceTeacher.getId());
        int status = teacherSelect.getStatus();
        if (status == 2) {
            practiceTeacher.setStatus(3);
            PracticeSup practiceSup = practiceSupMapper.selectOne(PracticeSup.builder().ptid(teacherSelect.getId()).build());
            practiceSup.setStatus(3);
            if(practiceTeacherMapper.updateByPrimaryKeySelective(practiceTeacher)!=0&&
                    practiceSupMapper.updateByPrimaryKeySelective(practiceSup)!=0)
                return true;
            return  false;
        }
        if(practiceTeacherMapper.updateByPrimaryKeySelective(practiceTeacher)!=0)
        return true;
        return false;
    }

    @Override
    public Boolean updatePracticeSup(PracticeSup practiceSup) {
        PracticeSup supSelect = practiceSupMapper.selectByPrimaryKey(practiceSup.getId());
        PracticeTeacher practiceTeacher = PracticeTeacher.builder().id(supSelect.getPtid()).status(practiceSup.getStatus()).build();
        if (
                practiceSupMapper.updateByPrimaryKeySelective(practiceSup) != 0
                        && practiceTeacherMapper.updateByPrimaryKeySelective(practiceTeacher) != 0
                ) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deletePracticeTeacher(PracticeTeacher practiceTeacher) {
        if (practiceTeacherMapper.deleteByPrimaryKey(practiceTeacher) != 0
             &&practiceSupMapper.delete(PracticeSup.builder().ptid(practiceTeacher.getId()).build())!=0){
            return true;
        }
        return false;
    }

    @Override
    public PracticeSup getPracticeSup(PracticeSup practiceSup) {
        return practiceSupMapper.selectByPrimaryKey(practiceSup);
    }

    @Override
    public PracticeTeacher getPracticeTeacher(PracticeTeacher practiceTeacher) {
        return practiceTeacherMapper.selectByPrimaryKey(practiceTeacher);
    }
}
