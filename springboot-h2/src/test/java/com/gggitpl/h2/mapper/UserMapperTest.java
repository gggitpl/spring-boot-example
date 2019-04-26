package com.gggitpl.h2.mapper;

import static org.junit.Assert.*;

import com.gggitpl.h2.model.User;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void findAll() {
    List<User> all = userMapper.findAll();
    log.debug("{}",all);
  }

}