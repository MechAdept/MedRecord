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
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * Implements the methods defined in the user service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Transactional
@PropertySource(value = "classpath:/properties/application.properties")
public class UserServiceImpl implements UserService {

    @Value("${project.upload.path}")
    String projectUploadPath;

    @Value("${server.upload.path}")
    String serverUploadPath;

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
    public void create(final UserFormDTO formDTO) {
        User user = userConverter.formDtoToEntity(formDTO);
        user.setPassword(bCryptPasswordEncoder.encode(formDTO.getPassword()));
        user.setRoles(roleService.findByIds(formDTO.getRolesId()));
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
        map.put("pageCount", count / pageSize);
        map.put("elementsCount", count);
        return map;
    }

    @Override
    public List<UserDataDTO> findPatients() {
        Role role = roleRepository.findRoleByName(Roles.ROLE_PATIENT.name());
        return userConverter.entitiesToDataDtoList(userRepository.getAllByRolesIs(role));
    }

    @Override
    public void saveImage(Long id, MultipartFile file) {
        User user = userRepository.getOne(id);
        MultipartFile secondFile = file;
        if (file != null) {
            File projectUploadDir = new File(projectUploadPath);
            File serverUploadDir = new File(serverUploadPath);
            if (projectUploadDir.exists()) {
                projectUploadDir.mkdir();
            }
            if (serverUploadDir.exists()) {
                serverUploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            try {
                file.transferTo(new File(projectUploadPath + "/" + resultFileName));
                File copied = new File( serverUploadPath + "/" + resultFileName);
                FileUtils.copyFile(new File(projectUploadPath + "/" + resultFileName), copied);
                //todo: add file delete
                user.setImg(resultFileName);
            } catch (IOException e) {
                System.out.println("OMG");
            }
        }
        userRepository.save(user);
    }

    @Override
    public void updatePassword(Long id, String password) {

    }

    @Override
    public void updatePhoto(Long id, MultipartFile file) {

    }

    @Override
    public void updateProfile(Long id, UserFormDTO formDTO) {

    }

    @Override
    public void updateRoles(Long id, UserFormDTO formDTO) {

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