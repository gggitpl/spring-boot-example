package com.gggitpl.mapper;

import com.gggitpl.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wsj
 * 2018\12\14 0014
 */
@Component
@Mapper
public interface TeacherMapper {

    @Insert("insert into t_teacher (name) values(#{name})")
    int insert(final Teacher teacher);

    @Select("select * from t_teacher where id=#{id}")
    Teacher getById(final Integer id);

    @Select("select * from t_teacher t inner join t_student_teacher st on t.id=st.teacher_id where st.student_id=#{id}")
    List<Teacher> getByStudentId(final Integer id);

}
