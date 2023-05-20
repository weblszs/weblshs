package com.Qiu.dao;

import com.Qiu.domain.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseDao {

    @Insert("insert into c_course (name,hours,sid) values(#{name},#{hours},#{sid})")
    public int save(Course course);

    @Update("update c_course set  name = #{name}, hours = #{hours} , sid=#{sid} where id = #{id}")
    public int update(Course course);

    @Delete("delete from c_course where id = #{id}")
    public int delete(Integer id);

    @Select("select * from c_course where id = #{id}")
    public Course getById(Integer id);

    @Select("select * from c_course")
    public List<Course> getAll();
}
