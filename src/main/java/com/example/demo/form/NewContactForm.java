package com.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewContactForm {
    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String tag;
}
