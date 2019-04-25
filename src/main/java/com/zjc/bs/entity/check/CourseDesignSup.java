package com.zjc.bs.entity.check;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.base.Page;
import lombok.*;
import org.apache.catalina.mapper.Mapper;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courseDesignSup")
@Builder
public class CourseDesignSup  extends Page {
    @Id
    @Column( insertable = false, updatable = false)
//    @KeySql(dialect = IdentityDialect.SQLSERVER)
    @GeneratedValue(generator = "JDBC")
    private Integer id;


    private Integer startyear;

    private Integer endyear;

    private Integer term;

    private String coursename;

    private String classname;

    private String dep;

    private Integer tid;

    private Integer pid;

    private Boolean t1;

    private Boolean t2;

    private Boolean t3;

    private Boolean t4;

    private Boolean t5;

    private Boolean t6;

    private Boolean t7;

    private Boolean t8;

    private Boolean t9;

    private Boolean t10;

    private Boolean t11;

    private Boolean t12;

    private Boolean t13;

    private Boolean t14;

    private Boolean t15;

    private Boolean t16;

    private Boolean t17;

    private Boolean t18;

    private Boolean t19;

    private Date createtime;

    private Integer status;

    private Integer cdtid;


}