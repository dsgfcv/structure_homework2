package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.form.LoginForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

    User selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsernameAndPassword(LoginForm loginForm);

    List<User> selectByUserIds(@Param("userIds") List<Integer> userIds);
}