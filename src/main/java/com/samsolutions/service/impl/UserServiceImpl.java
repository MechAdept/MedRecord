package com.samsolutions.service.impl;

import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.roles.Roles;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.UserService;
import groovy.grape.GrapeIvy;
import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(final UserFormDTO formDTO) {
        User user = userConverter.formDtoToEntity(formDTO);
        user.setPassword(bCryptPasswordEncoder.encode(formDTO.getPassword()));
        user.setRoles(roleService.findRolesById(formDTO.getRolesId()));
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(final String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setRoles(roleRepository.getRolesByUsers(user));
        }
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
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
        user.setRoles(roleRepository.getRolesByUsers(user));
        return userConverter.entityToDataDto(user);
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
        List<Role> roleDTOList = user.getRoles();
        roleDTOList.remove(role);
        user.setRoles(roleDTOList);
        userRepository.save(user);
    }

    @Override
    public Map<String, Object> getMapAndPageByRole(Long id, Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Role role = roleRepository.getOne(id);
        Map<String, Object> map = new HashMap<>();
        map.put("DTOList", getPageByRole(role, pageNo, pageSize, desc, sort));
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("desc", desc);
        map.put("sort", sort);
        map.put("pageCount", pageCountByRole(pageSize, role));
        map.put("elementsCount", countByRole(role));
        map.put("roleDTO", role);
        return map;
    }

    public List<UserDataDTO> getMapAndPageByPatient(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Role role = roleRepository.findRoleByName("ROLE_PATIENT");
        return getPageByRole(role, pageNo, pageSize, desc, sort);
    }


    @Override
    public Map<String, Object> getMapAndPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Map<String, Object> map = new HashMap<>();
        Long count = userRepository.count();
        map.put("DTOList", getPage(pageNo, pageSize, desc, sort));
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("desc", desc);
        map.put("sort", sort);
        map.put("pageCount", count/pageSize);
        map.put("elementsCount", count);
        return map;
    }

    @Override
    public List<UserDataDTO> findPatients() {
        Role role = roleRepository.findRoleByName("ROLE_PATIENT");
        return userConverter.entitiesToDataDtoList(userRepository.getAllByRolesIs(role));
    }

    @Override
    public void saveImage(Long id, MultipartFile file) {
        String uploadPath = "C:/Users/ulbraz/IdeaProjects/MedRecord/src/main/webapp/resources/img";
        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String fileName = file.getOriginalFilename();
            UserFormDTO userFormDTO = new UserFormDTO();
            userFormDTO.setImg(fileName);
            try {
                file.transferTo(new File(fileName));
                save(userFormDTO);
            } catch (Exception le) {
                System.out.println("asdas");
            }
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDataDTO> findDoctors() {
        List<Role> allRoles = new ArrayList<>(roleRepository.findAll());
        List<Role> systemRoles = new ArrayList<>();
        for (Roles role : Roles.values()) {
            systemRoles.add(roleRepository.findRoleByName(role.getAuthority()));
        }
        allRoles.removeAll(systemRoles);
        return userConverter.entitiesToDataDtoList(userRepository.findByRolesInOrderById(new ArrayList<>(allRoles)));
    }

    private Pageable getPageable(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        if (desc) {
            return PageRequest.of(pageNo - 1, pageSize, Sort.by(sort).descending());
        } else {
            return PageRequest.of(pageNo - 1, pageSize, Sort.by(sort).ascending());
        }
    }

    private List<UserDataDTO> getPageByRole(Role role, Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        Page<User> pagedResult = userRepository.findByRolesIs(role, pageable);
        if (pagedResult.hasContent()) {
            return userConverter.entitiesToDataDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    private Long pageCountByRole(Integer pageSize, Role role) {
        return userRepository.countUsersByRoles(role) / pageSize;
    }

    private Long countByRole(Role role) {
        return userRepository.countUsersByRoles(role);
    }
}