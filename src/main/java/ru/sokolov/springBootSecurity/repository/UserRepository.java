package ru.sokolov.springBootSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sokolov.springBootSecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
