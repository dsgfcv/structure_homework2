package com.example.demo.mapper;

import com.example.demo.entity.Contact;
import com.example.demo.form.GetContactsForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactMapper {
    int deleteByPrimaryKey(Integer id);

    Contact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);

    int insertRecord(Contact record);

    List<Contact> getContactListById(GetContactsForm getContactsForm);
}