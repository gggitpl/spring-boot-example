package com.gggitpl.oauth.mapper;

import com.gggitpl.oauth.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author wsj
 * 2018\12\13 0013
 */
@Component
@Mapper
public interface UserMapper {

    @Select("select * from t_user where username=#{username}")
    User loadUserByUsername(final String username);

}
