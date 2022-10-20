package com.example.demo.service;

import com.example.demo.entity.Contact;
import com.example.demo.form.ContactsRespForm;
import com.example.demo.form.GetContactsForm;
import com.example.demo.form.NewContactForm;
import com.example.demo.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    Result<List<ContactsRespForm>> getContactList(GetContactsForm getContactsForm);
    Result newContact(NewContactForm newContactForm);
}
