package com.org.house.controller;

import com.org.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getPage() {
        return "registration";
    }

    @PostMapping
    public String addUser(@RequestParam String username, @RequestParam String firstName,
                        @RequestParam String lastName, @RequestParam String email,
                        @RequestParam String password) {
        userService.addUser(email, password, firstName, lastName, username);
        return "redirect:/";
    }
}
