package com.samsolutions.service.impl;

import com.samsolutions.converter.DTOConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.service.UserService;
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

    DTOConverter<User, UserDTO> converter = new UserConverter();

    @Autowired
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void update(UserDTO userDTO) {
        userRepository.updateUser(userDTO.getId(),userDTO.getUsername(),userDTO.getPassword(),new ArrayList<Role>(userDTO.getRoles()));
    }

    @Override
    public List<UserDTO> getUsers() {
        return converter.EListToDTO(userRepository.findAll());
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = converter.DTOToEntity(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDTO findUserById(Long id) {
        return converter.EntityToDTO(userRepository.findOne(id));
    }
}