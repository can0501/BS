package com.zjc.bs.service.check.impl;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.check.Paper;
import com.zjc.bs.mapper.check.PaperMapper;
import com.zjc.bs.mapper.check.PaperMapper;
import com.zjc.bs.service.check.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperMapper PaperMapper;
    @Override
    public List<Paper> getPaperByPage(Paper Paper) {
        PageHelper.startPage(Paper.getPage(), Paper.getLimit());

        return PaperMapper.select(Paper);
    }

    @Override
    public Paper getPaper(Paper Paper) {
        return PaperMapper.selectByPrimaryKey(Paper.getId());
    }

    @Override
    public Boolean addPaper(Paper Paper) {

        Paper.setStatus(0);

        if(PaperMapper.insert(Paper)!=0)
        return true;
        return false;
    }

    @Override
    public Boolean updatePaperTeacher(Paper Paper) {
        Paper res = PaperMapper.selectByPrimaryKey(Paper.getId());
        if(res.getStatus()==2)
            Paper.setStatus(3);
        if(PaperMapper.updateByPrimaryKeySelective(Paper)!=0)
            return true;
        return false;
    }

    @Override
    public Boolean updatePaperSup(Paper Paper) {
        if(PaperMapper.updateByPrimaryKeySelective(Paper)!=0)
            return true;
        return false;
    }


    @Override
    public Boolean deletePaper(Paper Paper) {
        if(PaperMapper.deleteByPrimaryKey(Paper)!=0)
            return true;
        return false;
    }
}
