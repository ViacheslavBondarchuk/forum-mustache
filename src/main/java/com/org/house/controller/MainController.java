package com.org.house.controller;

import com.org.house.dto.UserDTO;
import com.org.house.entity.User;
import com.org.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getPage() {
        return "Main";
    }

    @PostMapping("/")
    public User addUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

}
