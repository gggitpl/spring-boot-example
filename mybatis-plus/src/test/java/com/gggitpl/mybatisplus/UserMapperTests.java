package com.gggitpl.mybatisplus;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gggitpl.mybatisplus.mapper.UserMapper;
import com.gggitpl.mybatisplus.model.User;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void testSelect() {
    List<User> users = userMapper.selectList(null);
    Assert.assertEquals(5, users.size());
    users.forEach(System.out::println);
  }

}
