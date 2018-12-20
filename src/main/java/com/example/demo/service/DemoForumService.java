package com.example.demo.service;

import com.example.demo.dao.ForumDAO;
import com.example.demo.entities.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoForumService implements ForumService {

    @Autowired
    ForumDAO forumDAO;

    @Override
    public Forum getForumByPath(String path) {
        return forumDAO.getForumByPath(path);
    }
}
