package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}/profile")
    public String viewUserProfile(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user",user);
        return "user/profile";
    }

    @PostMapping("register")
    public String register(@RequestBody User user) {
        user.setId((long) 0);
        userService.save(user);
        return "redirect:home";
    }

// need a request object that will hold some info about the report
//    @PostMapping("{userId}/report")

    @GetMapping("{userId}/settings")
    public String getUserSettings(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user",user);
        return "user/settings";
    }

    @PutMapping("{userId}/settings")
    public String updateUserSettings(@PathVariable Long userId, @RequestBody User newConfig) {
        // iterate over elements
        User oldConfig = userService.getUserById(userId);
        // set oldconfig according to newconfig
        return "redirect:user/" + userId + "/profile"; //change this to the config route
    }

    @DeleteMapping("{userId}/remove")
    public String deleteUser(@PathVariable Long userId) {
        // delete user
        return "redirect:home";
    }

}
