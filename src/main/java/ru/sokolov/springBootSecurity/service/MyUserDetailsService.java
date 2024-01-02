package ru.sokolov.springBootSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.sokolov.springBootSecurity.dao.UserDao;
import ru.sokolov.springBootSecurity.dao.UserDaoImpl;
import ru.sokolov.springBootSecurity.model.Role;
import ru.sokolov.springBootSecurity.model.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class MyUserDetailsService implements UserDetailsService {
    private final UserDao userDao;

    @Autowired
    public MyUserDetailsService(UserDaoImpl userService) {
        this.userDao = userService;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByUserEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoles(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}