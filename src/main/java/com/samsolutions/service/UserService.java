package com.samsolutions.service;

import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void update(UserDTO userDTO);

    List<UserDTO> getUsers();

    void save(UserDTO userDTO);

    User findByUsername(String username);

    void delete(Long id);

    UserDTO findUserById(Long id);
}