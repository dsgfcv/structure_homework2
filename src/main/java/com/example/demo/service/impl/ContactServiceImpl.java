package com.example.demo.service.impl;

import com.example.demo.entity.Contact;
import com.example.demo.entity.User;
import com.example.demo.enums.ResultEnum;
import com.example.demo.form.ContactsRespForm;
import com.example.demo.form.GetContactsForm;
import com.example.demo.form.NewContactForm;
import com.example.demo.mapper.ContactMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.result.Result;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public Result<List<ContactsRespForm>> getContactList(GetContactsForm getContactsForm) {
        return getContactsRespForm(getContactsForm);
    }

    public Result newContact(NewContactForm newContactForm){
        String username = newContactForm.getUsername();
        User user = userMapper.selectByUsername(username);
        if(user == null){
            return Result.fail(ResultEnum.NONUSER);
        }
        Integer userOneId = newContactForm.getId();
        Integer userTwoId = user.getId();
        String type = newContactForm.getTag();
        System.out.println(userOneId);
        System.out.println(userTwoId);
        System.out.println(type);

        int i = contactMapper.insertRecord(new Contact(userOneId, userTwoId, type));
        if(i == 1)
            return Result.success();
        return Result.fail(ResultEnum.INSERTFAIL);
    }

    public Result<List<ContactsRespForm>> getContactsRespForm(GetContactsForm getContactsForm){
        //联系人
        List<Contact> contactList = contactMapper.getContactListById(getContactsForm);

        //联系人类型、id
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Integer> userIds = new ArrayList<>();
        ArrayList<ContactsRespForm> contactsRespForm = new ArrayList<ContactsRespForm>();
        for(Contact c : contactList) {
            types.add(c.getType());
            userIds.add(c.getUserTwo());
            contactsRespForm.add(new ContactsRespForm(c.getType()));
        }

        //联系人信息
        List<User> userInfos = userMapper.selectByUserIds(userIds);
        for(int i = 0;i < userIds.size();i++){
            wrap(contactsRespForm.get(i),userInfos.get(i));
        }
        System.out.println(contactsRespForm);
        return Result.success(contactsRespForm);
    }
    public void wrap(ContactsRespForm form,User user){
        form.setEmail(user.getEmail());
        form.setName(user.getUsername());
        form.setPhone(user.getPhone());
    }
}
