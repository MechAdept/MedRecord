package com.samsolutions.service;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getUsers();
    void save(UserDTO user);
    User findByUsername(String username);
    void delete(Long id);
}