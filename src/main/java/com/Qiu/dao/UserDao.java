package com.Qiu.dao;

import com.Qiu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from user where email = #{email} and password = #{password}")
    User getByAll(@Param("email") String email, @Param("password")  String password);


    @Select("select * from user where email = #{email}")
    User getByEmail(String email);


    @Insert("insert into user values(null,#{email},#{password})")
    int save(User user);

    @Select("select * from user where email = #{user.email} and password = #{user.password}")
    User login(User user);

}
