package ru.sokolov.springBootSecurity.service;

import ru.sokolov.springBootSecurity.model.User;

import java.util.List;

public interface UserService {

    User findByUserEmail(String email);

    User getUser(Long id);

    List<User> getAllUsers();

    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);

}