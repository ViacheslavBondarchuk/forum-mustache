package com.org.house.controller;

import com.org.house.DTO.UserDTO;
import com.org.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addUser(@Validated @ModelAttribute(name = "user") UserDTO userDTO) {
        userService.addUser(userDTO);
        return "redirect:/";
    }
}
