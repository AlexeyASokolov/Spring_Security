package ru.sokolov.springBootSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @GetMapping("/")
    public String loginPage() {
        return "/login";
    }
}