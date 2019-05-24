package com.samsolutions.service;
import com.samsolutions.entity.Users;

import java.util.List;

public interface UsersDataService  {

    List<Users> findAll();
    List<Users> findByLogin(String login);
    List<Users> findById(Integer id);
}