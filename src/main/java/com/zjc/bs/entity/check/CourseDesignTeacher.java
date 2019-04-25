package com.zjc.bs.entity.check;

import com.zjc.bs.base.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Table(name = "courseDesignTeacher")
public class CourseDesignTeacher extends Page {
    @Id
    @Column( insertable = false, updatable = false)
//    @KeySql(dialect = IdentityDialect.SQLSERVER)
    @GeneratedValue(generator = "JDBC")//此处加上注解
    private Integer id;

    private Integer startyear;

    private Integer endyear;

    private Integer term;

    private Integer pid;

    private String classname;

    private String dep;

    private String coursename;

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

    private Boolean t20;

    private Boolean t21;

    private Boolean t22;

    private Boolean t23;

    private Boolean t24;

    private Boolean t25;

    private String content;

    private Date createtime;

    private Integer status;


}