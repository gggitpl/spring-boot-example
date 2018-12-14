package com.gggitpl.mapper;

import com.gggitpl.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wsj
 * 2018\12\14 0014
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void insertTest() {
        Student student = Student.builder().name("张三").build();
        int result = studentMapper.insert(student);
        assertEquals(1,result);
        log.debug("id: {}", student.getId());
    }

    @Test
    public void getByIdTest() {
        Student student = studentMapper.getById(1);
        log.debug("{}", student);
        assertNotNull(student);
    }

    @Test
    public void getByNameTest() {
        //List<Student> students = studentMapper.getByName("张");
        List<Student> students = studentMapper.getByNameOrderByColumn("张", "id");
        assertTrue(!students.isEmpty());
    }

    @Test
    public void getAllTest() {
        List<Student> students = studentMapper.getAll();
        log.debug("{}", students);
        assertTrue(!students.isEmpty());
    }

}
