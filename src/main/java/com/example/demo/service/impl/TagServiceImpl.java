package com.example.demo.service.impl;

import com.example.demo.entity.Tag;
import com.example.demo.mapper.TagMapper;
import com.example.demo.result.Result;
import com.example.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Result<List<Tag>> getTags() {
        List<Tag> tags = tagMapper.selectAllTags();
        return Result.success(tags);
    }
}
