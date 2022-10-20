package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.enums.ResultEnum;
import com.example.demo.form.LoginForm;
import com.example.demo.form.LoginRespForm;
import com.example.demo.mapper.UserMapper;
import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Result<LoginRespForm> checkLogin(LoginForm loginForm) {
        System.out.println(loginForm);
        User user = userMapper.selectByUsernameAndPassword(loginForm);

        if(user == null)
            return Result.fail(ResultEnum.NONUSER,null);

        String token = JwtUtil.getJwtToken(user.getId());
        user.setPassword("");
        LoginRespForm loginRespForm = new LoginRespForm(token, user);
        return Result.success(loginRespForm);
    }

    @Override
    public Result<User> selectUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setPassword("");
        return Result.success(user);
    }
}
