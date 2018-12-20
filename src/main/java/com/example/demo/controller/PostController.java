package com.example.demo.controller;

import com.example.demo.entities.Link;
import com.example.demo.service.LinkService;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forum/{forumPath}/link/{linkId}/post")
public class PostController {

    private LinkService linkService;

    private PostService postService;

    @Autowired
    public PostController(LinkService linkService, PostService postService) {
        this.linkService = linkService;
        this.postService = postService;
    }

    @GetMapping("/{postId}")
    public String showPost(@PathVariable Long linkId, Model model){
        Link link = linkService.getLinkById(linkId);
        model.addAttribute("link", link);
        return "link/link";
    }
}
