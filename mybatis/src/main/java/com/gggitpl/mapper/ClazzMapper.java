package com.gggitpl.mapper;

import com.gggitpl.model.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author wsj
 * 2018\12\14 0014
 */
@Component
@Mapper
public interface ClazzMapper {

    @Select("select * from t_clazz where id=#{id}")
    Clazz getById(final Long id);

}
