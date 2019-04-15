package com.zjc.bs.entity.admin;

import com.zjc.bs.base.Page;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "people")
public class People extends Page {
    @Id
    @Column( insertable = false, updatable = false)
    @KeySql(dialect = IdentityDialect.SQLSERVER)
    private Integer id;


    private String name;

    private String tel;

    private String home;

    private String sex;

    private String dep;

    private String username;

    private String password;

    private Integer role;

}