package com.example.demo.dao;

import com.example.demo.entities.User;

public interface UserDAO {
    User getUserByUsername(String username);
    void save(User user);
    public User getUserById(Long id);
}
