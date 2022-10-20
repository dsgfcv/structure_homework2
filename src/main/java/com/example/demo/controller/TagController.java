package com.example.demo.controller;

import com.example.demo.entity.Tag;
import com.example.demo.result.Result;
import com.example.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("/tags")
    public Result<List<Tag>> getTags(){
        return tagService.getTags();
    }
}
