package com.org.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discussion")
public class DiscussionController {

    @GetMapping
    public String getPage() {
        return "discussion";
    }
}
