package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.form.GetUserByIdForm;
import com.example.demo.form.LoginForm;
import com.example.demo.form.LoginRespForm;
import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public Result<LoginRespForm> signup(@RequestBody LoginForm loginForm){
        return userService.checkLogin(loginForm);
    }

    @PostMapping("/getUserById")
    public Result<User> getUserById(@RequestBody GetUserByIdForm getUserByIdForm){
        return userService.selectUserById(getUserByIdForm.getUserId());
    }
}
