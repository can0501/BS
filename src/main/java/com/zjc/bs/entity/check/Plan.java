package com.zjc.bs.entity.check;

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
@Table(name = "coursePlan", schema = "dbo")
public class Plan extends Page {
    @Id
    @Column( insertable = false, updatable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer startyear;

    private Integer term;

    private String coursename;

    private String classname;

    private String teachername;

    private Integer grade;

    private Integer classnum;

    private Integer studytime;

    private String bookname;

    private String bookauther;

    private String bookpublish;
     private Date booktime;

    private String preference;

    private Integer speaktime;

    private Integer experiencetime;

    private Integer other;

    private Integer pid;

    private Integer status;

    private Integer examtype;

    private Integer exam;

    private Integer housework;

    private Integer classperformance;

    private Integer smallexam;

    private Integer experience;

    private Integer smallpaper;

    private Integer middleexam;


}