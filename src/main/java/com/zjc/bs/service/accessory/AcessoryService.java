package com.zjc.bs.service.accessory;

import com.zjc.bs.entity.accessory.Accessory;

import java.util.List;

public interface AcessoryService {
    Boolean addAccessory(Accessory accessory);

    List<Accessory> getAccessoryBypage(Accessory accessory);
    List<Accessory> getAccessory (Accessory accessory);

    Boolean deleteAccessory(Accessory accessory);
}
