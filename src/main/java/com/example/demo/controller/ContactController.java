package com.example.demo.controller;

import com.example.demo.entity.Contact;
import com.example.demo.form.ContactsRespForm;
import com.example.demo.form.GetContactsForm;
import com.example.demo.form.NewContactForm;
import com.example.demo.result.Result;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/contactlist")
    public Result<List<ContactsRespForm>> contactList(@RequestBody GetContactsForm getcontactsForm){
        return contactService.getContactList(getcontactsForm);
    }

    @PostMapping("/newContact")
    public Result newContact(@RequestBody NewContactForm newContactForm){
        return contactService.newContact(newContactForm);
    }
}
