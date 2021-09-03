package com.daydreamer.usersapi.service;

import com.daydreamer.usersapi.domain.Role;
import com.daydreamer.usersapi.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    User signUpUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();
}