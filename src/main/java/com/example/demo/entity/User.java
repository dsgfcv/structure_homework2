package com.example.demo.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String avatar;
    private String username;
    private String email;
    private String password;
    private String phone;
    public User(Integer id, String avatar, String username, String email) {
        this.id = id;
        this.avatar = avatar;
        this.username = username;
        this.email = email;
    }

}
