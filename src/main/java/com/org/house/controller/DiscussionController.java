package com.org.house.controller;

import com.org.house.DTO.TopicDTO;
import com.org.house.service.DiscussionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

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

    @GetMapping("/topic/{id}")
    public String getTopic(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute("topic", discussionService.getTopic(Integer.parseInt(id)));
        model.addAttribute("comments", discussionService.getAllComments(Integer.parseInt(id)));
        return "topic";
    }

    @PostMapping("/topic/{id}")
    public String addComment(@PathVariable String id, @NotBlank @RequestParam(value = "textComment") String text) throws NotFoundException {
        discussionService.addComment(text, Integer.parseInt(id));
        System.out.println("HELLO");
        return "redirect:/topic/" + id;
    }
}
