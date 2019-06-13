package com.samsolutions.service;
import com.samsolutions.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findByLogin(String login);
    List<User> findById(Integer id);
}