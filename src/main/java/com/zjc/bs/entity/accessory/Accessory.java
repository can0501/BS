package com.zjc.bs.entity.accessory;

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
@Table(name = "accessory", schema = "dbo")
public class Accessory extends Page {
    @Id
    @Column( insertable = false, updatable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer fid;

    private String ftype;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date createtime;

    private String filename;



}