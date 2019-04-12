package com.zjc.bs.base;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.SqlServerMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;

/**
 * Created by tianjianping in 2018/7/3
 */
public interface BaseMapper<T> extends BaseSelectMapper<T>, BaseUpdateMapper<T>, BaseDeleteMapper<T>, SqlServerMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>, Marker {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}