package com.zjc.bs;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.zjc.bs.mapper") //扫描的mapper
@SpringBootApplication
public class BsApplication {
//asssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
    public static void main(String[] args) {
        SpringApplication.run(BsApplication.class, args);
    }

}

