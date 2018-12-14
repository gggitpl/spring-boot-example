package com.gggitpl.mapper;

import com.gggitpl.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author wsj
 * 2018\12\14 0014
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherMapperTests {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void insertTest() {
        Teacher teacher = Teacher.builder().name("东东老师").build();
        int result = teacherMapper.insert(teacher);
        assertEquals(1, result);
    }

}
