package com.zjc.bs.util;

import com.zjc.bs.entity.accessory.Accessory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhotoUtil extends HashMap<String ,Object> {
    public static PhotoUtil makePhotos(List<Accessory> list,String type) {
        PhotoUtil res = new PhotoUtil();
        res.put("title", type);
        res.put("id", 1);
        res.put("start", 0);
        List<Map<String, Object>> data = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> photo = new HashMap<>();
            photo.put("alt", list.get(0).getFilename());
            photo.put("pid", list.get(0).getId());
            photo.put("src", "/photos/" + type +"/" +list.get(0).getFilename());
            photo.put("thumb", null);
            data.add(photo);
        }
        res.put("data", data);
        return res;
    }
}
