package com.samsolutions.service;
import com.samsolutions.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //crud
    void createUser(User user);
    List<User> findAll();
    void updateUser(User user);
    void delete(Integer id);
    boolean exists(User user);

    //other methods
    User findById(Integer id);

    //security
    void save(User user);
    User findByUsername(String username);
}