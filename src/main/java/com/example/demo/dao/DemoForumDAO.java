package com.example.demo.dao;

import com.example.demo.entities.Forum;
import com.example.demo.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoForumDAO implements ForumDAO {

    @Autowired
    ForumRepository forumRepository;

    @Override
    public Forum getForumByPath(String path) {
        return forumRepository.findByPath(path);
    }
}
