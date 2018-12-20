package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoUserService implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }
}
