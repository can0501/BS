package com.zjc.bs.entity.admin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "bsuser")
public class BsUser {
    @Id
    private Integer id;

    private String username;

    private String password;

    private Integer role;


}