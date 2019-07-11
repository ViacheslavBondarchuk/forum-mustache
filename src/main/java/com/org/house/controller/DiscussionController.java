package com.org.house.controller;

import com.org.house.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discussion")
public class DiscussionController {
    @Autowired
    private DiscussionService discussionService;

    @GetMapping
    public String getPage(Model model) {
        model.addAttribute("topics", discussionService.getAllTopics());
        return "discussion";
    }

}
