package ru.sokolov.springBootSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sokolov.springBootSecurity.model.User;
import ru.sokolov.springBootSecurity.service.UserServiceImpl;

import java.security.Principal;

@Controller
public class UserController {
    private final UserServiceImpl userServiceImpl;
    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user")
    public String userPage(Model model, Principal principal) {
        User user = userServiceImpl.findByUserName(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}
