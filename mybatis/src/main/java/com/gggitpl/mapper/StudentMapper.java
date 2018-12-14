package com.gggitpl.mapper;

import com.gggitpl.model.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @author wsj
 * 2018\12\14 0014
 */
@Component
@Mapper
public interface StudentMapper {

    /**
     * statement 要执行的sql语句<br>
     * resultType 指定sql执行的结果类型<br>
     * keyProperty 指定查询结果赋值给对象中的哪一个字段 读数据库<br>
     * keyColumn 指定查询结果赋值给数据库表中的哪一个列 写数据库<br>
     * before 插入前 true 插入后 false
     *
     * @param student
     * @return
     */
    @Insert("insert into t_student (id, name) values(#{id},#{name})")
    //id字段为自增主键时,在插入数据后获取主键ID并插入student
    //@SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = int.class)
    //在插入数据之前获取值并赋值给student后插入数据库
    @SelectKey(statement = "select count(*)+1 from t_student", keyProperty = "id", before = true, resultType = int.class)
    int insert(Student student);

    /**
     * 对查询结果字段进行映射
     *
     * @param id
     * @return
     */
    @Select("select * from t_student where id=#{id}")
    @Results({
            @Result(property = "id", column = "id",id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "clazzId", column = "clazz_id"),
            @Result(property = "teachers", column = "id", many = @Many(select = "com.gggitpl.mapper.TeacherMapper.getByStudentId")),
            @Result(property = "clazz", column = "clazz_id", one = @One(select = "com.gggitpl.mapper.ClazzMapper.getById"))
    })
    Student getById(final Integer id);

    @SelectProvider(type = SqlBuilder.class, method = "buildGetByName")
    List<Student> getByName(final String name);

    @SelectProvider(type = SqlBuilder.class, method = "buildGetByName")
    List<Student> getByNameOrderByColumn(final String name, final String orderByColumn);

    @Select("select * from t_student")
    List<Student> getAll();

    class SqlBuilder {
        public static String buildGetByName(final String name) {
            return new SQL() {{
                SELECT("*");
                FROM("t_student");
                if (Objects.nonNull(name)) {
                    WHERE("name like concat(#{name},'%')");
                }
                ORDER_BY("id");
            }}.toString();
        }

        public static String buildGetByNameOrderByColumn(final String name, final String orderByColumn) {
            return new SQL() {{
                SELECT("*");
                FROM("*");
                if (Objects.nonNull(name)) {
                    WHERE("name like concat(#{name},'%)");
                }
                if (Objects.nonNull(orderByColumn)) {
                    ORDER_BY(orderByColumn);
                }
            }}.toString();
        }
    }
}
