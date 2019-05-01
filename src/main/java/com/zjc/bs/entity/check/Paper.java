package com.zjc.bs.entity.check;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zjc.bs.base.Page;

import java.util.Date;

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
@Table(name = "paper", schema = "dbo")
public class Paper extends Page {
    @Id
    @Column( insertable = false, updatable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer pid;
    private String dep;

    private String classname;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date createtime;

    private String coursename;

    private Integer courseregin;

    private Integer coursetype;

    private Integer solvetype;

    private Integer startweek;

    private Integer endweek;

    private Integer placetype;

    private String teachername;

    private String education;

    private String content;

    private String condition;

    private Integer status;

    private String suggession;

    private String checkname;

}