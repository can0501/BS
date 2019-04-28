package com.zjc.bs.entity.check;

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
@Table(name = "practiceSup", schema = "dbo")
public class PracticeSup extends Page {
        @Id
            @Column( insertable = false, updatable = false)
            @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String coursename;

    private String classname;

    private String dep;

    private Integer teacher;

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

    private Boolean t20;

    private Integer status;

    private Integer startyear;

    private Integer term;
    private Integer ptid;


}