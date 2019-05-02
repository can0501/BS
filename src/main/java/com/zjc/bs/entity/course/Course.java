package com.zjc.bs.entity.course;

import com.zjc.bs.base.Page;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "course")
@Builder
public class Course extends Page {
    @Id
    @Column( insertable = false, updatable = false)
    @KeySql(dialect = IdentityDialect.SQLSERVER)
    private Integer id;

    private String name;

    private Integer tid;

    private String time;

    @Transient
    private String tname;

    private String classnumber;
    private String coursetype;
    private String educationtype;
    private String studentnum;
    private Integer grade;



}