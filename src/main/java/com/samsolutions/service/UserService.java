package com.samsolutions.service;
import com.samsolutions.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}