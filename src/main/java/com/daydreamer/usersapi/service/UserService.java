package com.daydreamer.usersapi.service;

import com.daydreamer.usersapi.domain.Role;
import com.daydreamer.usersapi.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User signUpUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();
}