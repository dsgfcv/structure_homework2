package com.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactsRespForm {
    private String name;
    private String email;
    private String phone;
    private String type;

    public ContactsRespForm(String type) {
        this.type = type;
    }
}
