package com.samsolutions.service.impl;

import com.samsolutions.converter.DTOConverter;
import com.samsolutions.converter.RoleConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.RoleDTO;
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

    private DTOConverter<User, UserDTO> userConverter = new UserConverter();
    private DTOConverter<Role, RoleDTO> roleConverter = new RoleConverter();

    @Autowired
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void update(final UserDTO userDTO) {
        List<RoleDTO> roleList = null;

        roleList.addAll(userDTO.getRoles());
        userRepository.updateUser(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(),
                new ArrayList<>(roleConverter.dtoListToEntities(roleList)));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userConverter.entitiesToDtoList(userRepository.findAll());
    }

    @Override
    public void save(final UserDTO userDTO) {
        User user = userConverter.dtoToEntity(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void delete(final Long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDTO findUserById(final Long id) {
        return userConverter.entityToDTO(userRepository.findOne(id));
    }

    /**
     * Returns userConverter.
     *
     * @return UserConverter.
     */
    public DTOConverter<User, UserDTO> getUserConverter() {
        return userConverter;
    }

    /**
     * Sets userConverter.
     *
     * @param userConverter converter to be set.
     */
    public void setUserConverter(final DTOConverter<User, UserDTO> userConverter) {
        this.userConverter = userConverter;
    }

    /**
     * Returns roleConverter.
     *
     * @return RoleConverter.
     */
    public DTOConverter<Role, RoleDTO> getRoleConverter() {
        return roleConverter;
    }

    /**
     * Sets roleConverter.
     *
     * @param roleConverter converter to be set.
     */
    public void setRoleConverter(final DTOConverter<Role, RoleDTO> roleConverter) {
        this.roleConverter = roleConverter;
    }
}