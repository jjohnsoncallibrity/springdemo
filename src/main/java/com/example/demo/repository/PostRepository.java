package com.example.demo.repository;

import com.example.demo.entities.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
