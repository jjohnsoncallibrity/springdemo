package com.example.demo.controller;

import com.example.demo.entities.Forum;
import com.example.demo.entities.Link;
import com.example.demo.service.ForumService;
import com.example.demo.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("forum/{forumName}/link")
public class LinkController {

    private LinkService linkService;
    private ForumService forumService;

    @Autowired
    public LinkController(LinkService linkService, ForumService forumService) {
        this.linkService = linkService;
        this.forumService = forumService;
    }

    @GetMapping("submit")
    public String getSubmitForm(@PathVariable String forumName, Model model) {
        model.addAttribute("forumName", forumName);
        return "link/submit";
    }

    @GetMapping("")
    public String getAllLinks(@PathVariable String forumName, Model model) {
        Forum forum;
        if (forumName.equals("all")) {
            forum = new Forum();
            forum.setPath("all");
            forum.setForumName("SPRING DEMO");
            forum.setLinks(linkService.getAllByPageAndOffset(0,15));
        }
        else {
            forum = forumService.getForumByPath(forumName);
        }
        model.addAttribute("forum", forum);
        return "link/index";
    }

    @GetMapping("{linkId}")
    public String getLink(@PathVariable String forumName, @PathVariable Long linkId) {
        Link link = linkService.getLinkById(linkId);
        return "redirect:/forum/" + forumName
                + "/link/" + linkId + "/post/" + link.getPost().getId();
    }

    @PostMapping("")
    public String submitLink(@PathVariable String forumName, @RequestBody Link link) {
//        link.setForum(forumName);
        Forum forum = forumService.getForumByPath(forumName);
        linkService.save(link);
        return "redirect:link/" + link.getId();
    }
}
