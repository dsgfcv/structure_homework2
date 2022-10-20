package com.example.demo.mapper;

import com.example.demo.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> selectAllTags();
}