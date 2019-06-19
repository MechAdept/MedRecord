package com.samsolutions.service;
import com.samsolutions.entity.User;

import java.util.List;

public interface UserService {
    //crud
    void createUser(User user);
    List<User> findAll();
    void updateUser(User user);
    void delete(Integer id);
    boolean exists(User user);

    //other methods
    User findByLogin(String login);
    List<User> findById(Integer id);
}