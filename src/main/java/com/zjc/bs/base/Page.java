package com.zjc.bs.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;

@Setter
@Getter
public class Page {
    @Transient
    private Integer limit=1;
    @Transient
    private Integer page=10;
}
