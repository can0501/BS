package com.zjc.bs;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.mapper.admin.PeopleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BsApplicationTests {

    @Autowired
    PeopleMapper mapper;

    @Test
    public void contextLoads() {
        for (int i = 5; i <20 ; i++) {
            mapper.insertSelective(People.builder().username(i+"").name("王老"+i).sex("男").dep("智能技术与工程学院").home("重庆").role(1).tel("132240315"+i).password("1").build());
        }
        int  people = mapper.insertSelective(People.builder().username("212").password("1").build());
        int i=1;
    }

}

