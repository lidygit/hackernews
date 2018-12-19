package com.cskaoyan.hackernews.mapper;

import com.cskaoyan.hackernews.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface UserMapper {

    @Select({
            "select id, name, password, headUrl",
            "from user",
            "where id=#{id,jdbcType=INTEGER}"
    })
    User selectUserById(Integer id);

    @Insert({
            "insert into user (id,name,password,headUrl) ",
            "values(null,#{user.name},#{user.password},#{user.headUrl})"
    })
    int register(@Param("user") User user);

    @Select({
            "select * from user where name=#{user.name} and password=#{user.password}"
    })
    User login(@Param("user") User user);

    @Select({
            "select * from user where name=#{name}"
    })
    User selectUserByName(String name);

}