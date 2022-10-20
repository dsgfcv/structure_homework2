package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.form.LoginForm;
import com.example.demo.form.LoginRespForm;
import com.example.demo.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Result<LoginRespForm> checkLogin(LoginForm loginForm);
    Result<User> selectUserById(Integer id);
}
