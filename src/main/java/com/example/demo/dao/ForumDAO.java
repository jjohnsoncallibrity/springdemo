package com.example.demo.dao;

import com.example.demo.entities.Forum;

public interface ForumDAO {
    Forum getForumByPath(String path);
}
