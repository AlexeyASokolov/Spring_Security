package ru.sokolov.springBootSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sokolov.springBootSecurity.model.Role;
import ru.sokolov.springBootSecurity.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
