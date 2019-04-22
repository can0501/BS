package com.zjc.bs.entity.course;

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
@Table(name = "courseTask", schema = "dbo")
public class CourseTask extends Page {
    @Id
    @Column( insertable = false, updatable = false)
    @KeySql(dialect = IdentityDialect.SQLSERVER)
    private Integer id;

    private Integer pid;

    private Integer cid;

    private Integer status;
    @Column(name = "createDate")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @Transient
     private String courseTime;

    @Transient
    private String teacher;


    @Transient
    private String pname;
    @Transient
    private String cname;


}