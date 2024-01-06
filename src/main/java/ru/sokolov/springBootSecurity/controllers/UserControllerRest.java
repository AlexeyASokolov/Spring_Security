package ru.sokolov.springBootSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sokolov.springBootSecurity.model.User;
import ru.sokolov.springBootSecurity.dao.UserDaoImpl;
import ru.sokolov.springBootSecurity.service.UserService;

import java.security.Principal;
@RestController
@RequestMapping("/api/user")
public class UserControllerRest {
    private final UserService userService;

    @Autowired
    public UserControllerRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showAccount")
    public ResponseEntity<User> showUserAccount(Principal principal) {
        User user = userService.findByUserEmail(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}