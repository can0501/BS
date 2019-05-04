package com.zjc.bs.entity.estimate;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zjc.bs.base.Page;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estimateTeacher", schema = "dbo")
public class EstimateTeacher extends Page {
    @Id
    @Column( insertable = false, updatable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer t1;

    private Integer t2;

    private Integer t3;

    private Integer t4;

    private Integer t5;

    private Integer t6;

    private Integer t7;

    private Integer t8;

    private Integer t9;

    private Integer t10;

    private Integer t11;

    private Integer t12;

    private Integer t13;

    private Integer t14;

    private Integer t15;

    private Integer t16;

    private Integer t17;

    private Integer t18;

    private Integer t19;

    private Integer t20;

    private Integer pid;

    private String pcontent;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date createtime;

    private Integer status;

    private Integer old;

    private Integer teacherold;

    private String dep;

    private String coursename;

    private String classname;

    private String name;

}