package com.zjc.bs.entity.course;

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
@Table(name = "courseCommit", schema = "dbo")

public class CourseCommit extends Page {
    @Id
    @Column( insertable = false, updatable = false)
    @KeySql(dialect = IdentityDialect.SQLSERVER)
    private Integer id;

    private Integer ctid;

    private String ontifyid;

    private String content;

    private String suggestion;
    @Column(name = "createTime")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @Transient
    private Integer cid;

    @Transient
    private String teacher;

    @Transient
    private String pname;
    @Transient
    private String cname;


}