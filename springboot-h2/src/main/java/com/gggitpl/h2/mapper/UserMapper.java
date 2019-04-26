package com.gggitpl.h2.mapper;

import com.gggitpl.h2.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

  @Select("select * from t_user")
  List<User> findAll();
}
