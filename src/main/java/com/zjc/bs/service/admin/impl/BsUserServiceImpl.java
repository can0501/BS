package com.zjc.bs.service.admin.impl;

import com.zjc.bs.entity.admin.BsUser;
import com.zjc.bs.mapper.admin.BsUserMapper;
import com.zjc.bs.service.admin.BsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class BsUserServiceImpl implements BsUserService {
    @Autowired
    BsUserMapper bsUserMapper;

    @Override

    public BsUser login(BsUser bsUser) {
        BsUser bsUser1 = bsUserMapper.selectOne(bsUser);

        return bsUser1;
    }
}
