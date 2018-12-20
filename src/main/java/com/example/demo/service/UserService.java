package com.example.demo.service;

import com.example.demo.entities.User;

public interface UserService {
    public User getUserByUsername(String username);

    void save(User user);

    public User getUserById(Long id);
}
