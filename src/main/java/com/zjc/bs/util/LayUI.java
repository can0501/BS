package com.zjc.bs.util;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public class LayUI extends HashMap<String, Object> {
        public static LayUI data(long count, List data){
            LayUI r = new LayUI();
            r.put("code", 0);
            r.put("msg", "获取数据完成");
            r.put("count", count);
            r.put("data", data);
            return r;
        }


}
