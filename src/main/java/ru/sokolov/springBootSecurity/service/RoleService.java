package ru.sokolov.springBootSecurity.service;

import ru.sokolov.springBootSecurity.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();

    Role findById(Long id);
}
