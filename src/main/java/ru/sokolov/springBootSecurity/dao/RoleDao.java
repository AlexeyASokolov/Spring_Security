package ru.sokolov.springBootSecurity.dao;

import org.springframework.stereotype.Repository;
import ru.sokolov.springBootSecurity.model.Role;

import java.util.List;

@Repository
public interface RoleDao {
    List<Role> getRoles();

    Role findById(Long id);
}
