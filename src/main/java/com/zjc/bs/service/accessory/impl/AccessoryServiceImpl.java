package com.zjc.bs.service.accessory.impl;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.accessory.Accessory;
import com.zjc.bs.mapper.accessory.AccessoryMapper;
import com.zjc.bs.service.accessory.AcessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccessoryServiceImpl implements AcessoryService {
    @Autowired
    AccessoryMapper accessoryMapper;
    @Override
    public Boolean addAccessory(Accessory accessory) {
        if (accessoryMapper.insertSelective(accessory) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Accessory> getAccessoryBypage(Accessory accessory) {
        PageHelper.startPage(accessory.getPage(), accessory.getLimit());
        accessoryMapper.select(accessory);
        return null;
    }

    @Override
    public List<Accessory> getAccessory(Accessory accessory) {

        return accessoryMapper.select(accessory);
    }

    @Override
    public Boolean deleteAccessory(Accessory accessory) {
        if ((accessoryMapper.delete(accessory) != 0)) {
            return true;


        }
        return false;
    }
}
