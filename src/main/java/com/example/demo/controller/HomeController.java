package com.example.demo.controller;

import com.example.demo.properties.DemoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private DemoProperties demoProperties;

    @GetMapping("/")
    public String frontPage(Model model) {
        return "redirect:/forum/all/link";
    }
}
