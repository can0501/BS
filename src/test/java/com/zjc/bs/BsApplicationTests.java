package com.zjc.bs;

import com.zjc.bs.mapper.admin.BsUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BsApplicationTests {

    @Resource
    BsUserMapper bsUserMapper;
    @Test
    public void contextLoads() {
        System.out.println("-------------------------------------");
    }

}

