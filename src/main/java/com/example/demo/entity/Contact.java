package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    public Contact(Integer userOne, Integer userTwo, String type) {
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.type = type;
    }

    private Integer id;

    private Integer userOne;

    private Integer userTwo;

    private String type;
}