package com.samsolutions.service.impl;

import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.User;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

/**
 * Implements the methods defined in the user service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserDTO> getUsers() {
        return userConverter.entitiesToDtoList(userRepository.findAll());
    }

    @Override
    public void save(final UserDTO userDTO) {
        User user = userConverter.dtoToEntity(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public User findByUsername(final String username) {
        User user = userRepository.findByUsername(username);
        if (user != null){
            user.setRoles(roleService.getRolesEntityByUserId(user));
        }
        return user;
    }

    @Override
    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findUserById(final Long id) {
        return userConverter.entityToDTO(userRepository.getOne(id));
    }
}