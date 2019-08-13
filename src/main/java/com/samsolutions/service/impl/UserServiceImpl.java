package com.samsolutions.service.impl;

import com.samsolutions.converter.RoleConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.User;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Implements the methods defined in the user service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service("UserService")
@Transactional
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
    private RoleConverter roleConverter;

    @Autowired
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getUsers() {
        return userConverter.entitiesToDtoList(userRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }

    @Override
    public void save(final UserDTO userDTO) {
        User user = userConverter.dtoToEntity(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRoles(roleConverter.dtoSetToEntities(userDTO.getRoles()));
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(final String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setRoles(roleConverter.dtoSetToEntities(roleService.getRolesByUser(userConverter.entityToDTO(user))));
        }
        return user;
    }

    @Override
    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getPage(Integer pageNo, Integer pageSize, Boolean idReverse) {
        Pageable pageable;
        if(idReverse){
            pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
        }
        else {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").ascending());
        }
        Page<User> pagedResult = userRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return userConverter.entitiesToDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Long getPageCount(Integer pageSize) {
        return userRepository.count() / pageSize;
    }

    @Override
    public Long getTotalCount() {
        return userRepository.count();
    }

    @Override
    public UserDTO findUserWithRolesById(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        UserDTO userDTO = userConverter.entityToDTO(user);
        userDTO.setRoles(roleService.getRolesByUser(userDTO));
        return userDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findUserById(final Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return userConverter.entityToDTO(user);
    }

    @Override
    public void deleteRoleFromUserById(Long userId, Long roleId) {
        UserDTO userDTO = findUserWithRolesById(userId);
        RoleDTO roleDTO = roleService.findRoleById(roleId);
        Set<RoleDTO> roleDTOSet = userDTO.getRoles();
        roleDTOSet.remove(roleDTO);
        userDTO.setRoles(roleDTOSet);
        save(userDTO);
    }

    @Override
    public List<UserDTO> findUsersByRole(RoleDTO roleDTO) {
        return userConverter.entitiesToDtoList(userRepository.findUsersByRoles(roleConverter.dtoToEntity(roleDTO)));
    }
}