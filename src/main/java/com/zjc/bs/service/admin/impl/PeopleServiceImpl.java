package com.zjc.bs.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.mapper.admin.PeopleMapper;
import com.zjc.bs.service.admin.PeoplerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeoplerService {

    @Autowired
    PeopleMapper peopleMapper;
    @Override
    public People getByCondition(People people) {
        List<People> list = peopleMapper.select(people);
        if(list.size()==0)
        return null;
        return list.get(0);
    }

    @Override
    public Integer delete(Integer id) {
        return peopleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean update(People people) {
       if( peopleMapper.updateByPrimaryKeySelective(people)!=0)
        return true;
        return false;
    }

    @Override
    public Integer add(People people) {
        People p = People.builder().username(people.getUsername()).build();
        if(peopleMapper.selectCount(p)==0)
        return peopleMapper.insertSelective(people);
        return 0;
    }
    @Override
    public List<People> getListByPage(People people) {
        PageHelper.startPage(people.getPage(), people.getLimit());
        return peopleMapper.select(people);
    }

    @Override
    public Integer getCount(People people) {
        return peopleMapper.selectCount(people);
    }

    @Override
    public People login(People people) {
        return peopleMapper.login(people);
    }

    @Override
    public People get(Integer id) {
        return peopleMapper.selectByPrimaryKey(id);
    }
}
