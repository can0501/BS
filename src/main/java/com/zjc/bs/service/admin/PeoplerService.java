package com.zjc.bs.service.admin;

import com.zjc.bs.entity.admin.People;

import java.util.List;

public interface PeoplerService {
      People getByCondition(People people);
      Integer delete(Integer id);
      Boolean update(People people);
      Integer add(People people);
      List<People> getListByPage(People people);
      Integer getCount(People people);
      People login(People people);
      People get(Integer id);
}
