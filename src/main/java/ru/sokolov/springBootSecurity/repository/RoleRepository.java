package ru.sokolov.springBootSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sokolov.springBootSecurity.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
