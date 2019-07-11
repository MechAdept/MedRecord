package com.samsolutions.service.impl;

import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.User;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for (Object source : userList) {
            UserDTO target = new UserDTO();
            BeanUtils.copyProperties(source, target);
            userDTOList.add(target);
        }
        return userDTOList;
    }

    @Override
    public void save(UserDTO userDTO) {
        User userEntity = new User();
        BeanUtils.copyProperties(userDTO, userEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userEntity.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(userEntity);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}