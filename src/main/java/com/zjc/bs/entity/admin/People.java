package com.zjc.bs.entity.admin;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "people")
public class People {
    @Id
    private Integer id;

    private String name;

    private String tel;

    private String home;

    private String sex;

    private String dep;

    @Transient
    private Integer role;

}