package com.zjc.bs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zjc.bs.mapper") //扫描的mapper
@SpringBootApplication
public class BsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsApplication.class, args);
    }

}

