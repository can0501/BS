package com.zjc.bs.service.admin;

import com.zjc.bs.entity.admin.People;

import java.util.List;

public interface PeoplerService {
    public People getByCondition(People people);
    public Integer delete(Integer id);
    public Boolean update(People people);
    public Integer add(People people);
    public List<People> getListByPage(People people);
    public Integer getCount(People people);
    public People login(People people);
    public People get(Integer id);
}
