package com.samsolutions.service.impl;

import com.samsolutions.converter.RoleConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.data.UserDTO;
import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.RoleFormDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.roles.Roles;
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

import java.util.*;

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
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RoleConverter roleConverter;

    @Autowired
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(final UserFormDTO formDTO) {
        User user = userConverter.formDtoToEntity(formDTO);
        user.setPassword(bCryptPasswordEncoder.encode(formDTO.getPassword()));

        Set<Role> roles = roleService.findRolesById(formDTO.getRolesId());
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(final String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setRoles(roleConverter.formDtoSetToEntities(new HashSet<>(roleService.getRolesByUser(userConverter.entityToDataDto(user)))));
        }
        return user;
    }

    @Override
    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDataDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        Page<User> pagedResult = userRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return userConverter.entitiesToDataDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public UserDataDTO findWithRolesById(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        UserDataDTO userDTO = userConverter.entityToDataDto(user);
        userDTO.setRoles(new HashSet<>(roleService.getRolesByUser(userDTO)));
        return userDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDataDTO findById(final Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return userConverter.entityToDataDto(user);
    }

    @Override
    public void deleteRoleFromUserById(Long userId, Long roleId) {
        User user = userRepository.getOne(userId);
        Role role = roleRepository.getOne(roleId);
        Set<Role> roleDTOSet = user.getRoles();
        roleDTOSet.remove(role);
        user.setRoles(roleDTOSet);
        userRepository.save(user);
    }

//    @Override
//    public List<UserDTO> findPatientsWithoutHealth() {
//        return userConverter.entitiesToDtoList(userRepository.findAllByHealthIsNullAndRolesIs(roleConverter.dtoToEntity(
//                roleService.findRoleByName("ROLE_PATIENT"))));
//    }

    @Override
    public Map<String, Object> getMapAndPageByRole(Long id, Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        RoleDTO roleDTO = roleService.findById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("DTOList", getPageByRole(roleDTO, pageNo, pageSize, desc, sort));
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("desc", desc);
        map.put("sort", sort);
        map.put("pageCount", pageCountByRole(pageSize, roleDTO));
        map.put("elementsCount", countByRole(roleDTO));
        map.put("roleDTO", roleDTO);
        return map;
    }

    public List<UserDTO> getMapAndPageByPatient(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        RoleDTO roleDTO = roleService.findRoleByName("ROLE_PATIENT");
        return getPageByRole(roleDTO, pageNo, pageSize, desc, sort);
    }


    @Override
    public Map<String, Object> getMapAndPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Map<String, Object> map = new HashMap<>();
        map.put("DTOList", getPage(pageNo, pageSize, desc, sort));
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("desc", desc);
        map.put("sort", sort);
        map.put("pageCount", getPageCount(pageSize));
        map.put("elementsCount", getTotalCount());
        return map;
    }

    @Override
    public List<UserDataDTO> findPatients() {
        RoleDTO roleDTO = roleService.findRoleByName("ROLE_PATIENT");
        Role role = roleConverter.formDtoToEntity(roleDTO);
        return userConverter.entitiesToDataDtoList(userRepository.getAllByRolesIs(role));
    }

    @Override
    @Transactional(readOnly = true)
    public Set<UserDataDTO> findDoctors() {
        Set<Role> allRoles = roleConverter.formDtoSetToEntities(new HashSet<>(roleService.findAll()));
        Set<Role> systemRoles = new HashSet<>();
        for (Roles role : Roles.values()) {
            systemRoles.add(roleConverter.formDtoToEntity(roleService.findRoleByName(role.getAuthority())));
        }
        allRoles.removeAll(systemRoles);
        return userConverter.entitiesToDataDtoSet(userRepository.findByRolesInOrderById(new ArrayList<>(allRoles)));
    }

    private Pageable getPageable(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        if (desc) {
            return PageRequest.of(pageNo - 1, pageSize, Sort.by(sort).descending());
        } else {
            return PageRequest.of(pageNo - 1, pageSize, Sort.by(sort).ascending());
        }
    }

    private Long getPageCount(Integer pageSize) {
        return userRepository.count() / pageSize;
    }

    private Long getTotalCount() {
        return userRepository.count();
    }

    private List<UserDataDTO> getPageByRole(RoleFormDTO roleDTO, Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        Role role = roleConverter.formDtoToEntity(roleDTO);
        Page<User> pagedResult = userRepository.findByRolesIs(role, pageable);
        if (pagedResult.hasContent()) {
            return userConverter.entitiesToDataDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    private Long pageCountByRole(Integer pageSize, RoleFormDTO roleDTO) {
        return userRepository.countUsersByRoles(roleConverter.formDtoToEntity(roleDTO)) / pageSize;
    }

    private Long countByRole(RoleFormDTO roleDTO) {
        return userRepository.countUsersByRoles(roleConverter.formDtoToEntity(roleDTO));
    }
}