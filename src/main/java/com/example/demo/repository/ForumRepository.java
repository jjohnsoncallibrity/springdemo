package com.example.demo.repository;

import com.example.demo.entities.Forum;
import org.springframework.data.repository.CrudRepository;

public interface ForumRepository extends CrudRepository<Forum, Long> {
    Forum findByPath(String path);
}
