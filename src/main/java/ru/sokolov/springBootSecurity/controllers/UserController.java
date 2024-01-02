package ru.sokolov.springBootSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sokolov.springBootSecurity.model.User;
import ru.sokolov.springBootSecurity.dao.UserDaoImpl;

import java.security.Principal;

@Controller
public class UserController {
    private final UserDaoImpl userDaoImpl;

    @Autowired
    public UserController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @GetMapping("/user")
    public String userPage(Model model, Principal principal) {
        User user = userDaoImpl.findByUserEmail(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}