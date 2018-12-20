package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forum")
public class ForumController {
    @GetMapping("/{forumName}")
    public String getForumHome(@PathVariable String forumName) {
        return "redirect:/forum/" + forumName + "/link";
    }
}
