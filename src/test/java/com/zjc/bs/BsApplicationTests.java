package com.zjc.bs;

import com.github.pagehelper.PageHelper;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.entity.course.Course;
import com.zjc.bs.mapper.admin.PeopleMapper;
import com.zjc.bs.mapper.check.CourseDesignSupMapper;
import com.zjc.bs.mapper.course.CourseMapper;
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
    CourseDesignSupMapper mapper;

    @Test
    public void contextLoads() {
 
    }

}

