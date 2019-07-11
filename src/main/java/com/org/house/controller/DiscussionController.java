package com.org.house.controller;

import com.org.house.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @GetMapping("/discussion")
    public String getPage(Model model) {
        model.addAttribute("topics", discussionService.getAllTopics());
        return "discussion";
    }

    @GetMapping("/discussion/new")
    public String getPageAdditional(){
        return "addDiscussion";
    }

}
