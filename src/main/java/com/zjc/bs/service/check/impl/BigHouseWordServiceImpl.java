package com.zjc.bs.service.check.impl;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.check.BigHouseWordSup;
import com.zjc.bs.entity.check.BigHouseWordTeacher;
import com.zjc.bs.entity.check.PracticeSup;
import com.zjc.bs.entity.check.PracticeTeacher;
import com.zjc.bs.mapper.check.BigHouseWordSupMapper;
import com.zjc.bs.mapper.check.BigHouseWordTeacherMapper;
import com.zjc.bs.mapper.check.PracticeSupMapper;
import com.zjc.bs.mapper.check.PracticeTeacherMapper;
import com.zjc.bs.service.check.BigHouseWordService;
import com.zjc.bs.service.check.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigHouseWordServiceImpl implements BigHouseWordService {
    @Autowired
    BigHouseWordSupMapper bigHouseWordSupMapper;
    @Autowired
    BigHouseWordTeacherMapper bigHouseWordTeacherMapper;

    @Override
    public List<BigHouseWordTeacher> getBigHouseWordTeacherByPage(BigHouseWordTeacher practiceTeacher) {
        PageHelper.startPage(practiceTeacher.getPage(), practiceTeacher.getLimit());


        return bigHouseWordTeacherMapper.select(practiceTeacher);
    }

    @Override
    public List<BigHouseWordSup> getBigHouseWordSupByPage(BigHouseWordSup practiceSup) {
        PageHelper.startPage(practiceSup.getPage(), practiceSup.getLimit());
        return bigHouseWordSupMapper.select(practiceSup);
    }

    @Override
    public Boolean addBigHouseWordTeacher(BigHouseWordTeacher practiceTeacher) {
        practiceTeacher.setStatus(0);

        if (bigHouseWordTeacherMapper.insert(practiceTeacher) != 0
                && bigHouseWordSupMapper.insert(BigHouseWordSup.builder().term(practiceTeacher.getTerm()).dep(practiceTeacher.getDep()).bhwid(practiceTeacher.getId()).status(0).coursename(practiceTeacher.getCoursename()).classname(practiceTeacher.getClassname()).startyear(practiceTeacher.getStartyear()).build())!=0
                ) {
            return true;

        }
        return false;
    }

    @Override
    public Boolean updateBigHouseWordTeacher(BigHouseWordTeacher practiceTeacher) {
        BigHouseWordTeacher teacherSelect = bigHouseWordTeacherMapper.selectByPrimaryKey(practiceTeacher.getId());
        BigHouseWordSup practiceSup = bigHouseWordSupMapper.selectOne(BigHouseWordSup.builder().bhwid(teacherSelect.getId()).build());
        practiceSup.setDep(practiceTeacher.getDep());
        practiceSup.setStartyear(practiceTeacher.getStartyear());
        practiceSup.setTerm(practiceTeacher.getTerm());
        practiceSup.setCoursename(practiceTeacher.getCoursename());
        practiceSup.setClassname(practiceTeacher.getClassname());
        int status = teacherSelect.getStatus();
        if (status == 2) {
            practiceTeacher.setStatus(3);


            practiceSup.setStatus(3);
            if(bigHouseWordTeacherMapper.updateByPrimaryKeySelective(practiceTeacher)!=0&&
                    bigHouseWordSupMapper.updateByPrimaryKeySelective(practiceSup)!=0)
                return true;
            return  false;
        }
        if(bigHouseWordTeacherMapper.updateByPrimaryKeySelective(practiceTeacher)!=0&&bigHouseWordSupMapper.updateByPrimaryKeySelective(practiceSup)!=0)
        return true;
        return false;
    }

    @Override
    public Boolean updateBigHouseWordSup(BigHouseWordSup practiceSup) {
        BigHouseWordSup supSelect = bigHouseWordSupMapper.selectByPrimaryKey(practiceSup.getId());
        BigHouseWordTeacher practiceTeacher = BigHouseWordTeacher.builder().id(supSelect.getBhwid()).status(practiceSup.getStatus()).build();
        if (
                bigHouseWordSupMapper.updateByPrimaryKeySelective(practiceSup) != 0
                        && bigHouseWordTeacherMapper.updateByPrimaryKeySelective(practiceTeacher) != 0
                ) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBigHouseWordTeacher(BigHouseWordTeacher practiceTeacher) {
        if (bigHouseWordTeacherMapper.deleteByPrimaryKey(practiceTeacher) != 0
             &&bigHouseWordSupMapper.delete(BigHouseWordSup.builder().bhwid(practiceTeacher.getId()).build())!=0){
            return true;
        }
        return false;
    }

    @Override
    public BigHouseWordSup getBigHouseWordSup(BigHouseWordSup practiceSup) {
        return bigHouseWordSupMapper.selectByPrimaryKey(practiceSup);
    }

    @Override
    public BigHouseWordTeacher getBigHouseWordTeacher(BigHouseWordTeacher practiceTeacher) {
        return bigHouseWordTeacherMapper.selectByPrimaryKey(practiceTeacher);
    }
}
