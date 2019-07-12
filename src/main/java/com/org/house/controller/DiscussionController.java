package com.org.house.controller;

import com.org.house.DTO.TopicDTO;
import com.org.house.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @GetMapping("/discussion")
    public String getPage(Model model) {
        model.addAttribute("topics", discussionService.getAllTopics());
        return "discussion";
    }

    @PostMapping("/discussion")
    public String addTopic(@Validated @ModelAttribute TopicDTO topicDTO) {
        discussionService.saveDiscussion(topicDTO);
        return "redirect:/discussion";
    }

    @GetMapping("/topic")
    public String getTopic(@RequestParam(value = "id", required = true) String id){
        System.out.println(id);
        return "topic";
    }
}
