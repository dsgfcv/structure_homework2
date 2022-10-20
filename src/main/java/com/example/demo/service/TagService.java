package com.example.demo.service;

import com.example.demo.entity.Tag;
import com.example.demo.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {
    Result<List<Tag>> getTags();
}
