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
        PageHelper.offsetPage(1, 5);
        List list = mapper.selectAll();
        int i=1;
    }

}

