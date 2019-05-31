package com.samsolutions.service;
import com.samsolutions.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserEntity> findAll();
    List<UserEntity> findByLogin(String login);
    List<UserEntity> findById(Integer id);
}