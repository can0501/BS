package com.zjc.bs.mapper.admin;

import com.zjc.bs.entity.admin.BsUser;

public interface BsUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BsUser record);

    int insertSelective(BsUser record);

    BsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BsUser record);

    int updateByPrimaryKey(BsUser record);
}